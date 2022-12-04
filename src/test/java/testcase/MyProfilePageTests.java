package testcase;

import base.BaseTest;
import constants.Const;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyProfilePage;

public class MyProfilePageTests extends BaseTest {

    @Test
    public void testLoginUserHasProperUsernameDisplayedInHeader() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.enterUsername(Const.EMAIL_REGISTERED_USER);
        loginPage.enterPassword(Const.PASS_REGISTERED_USER);
        MyProfilePage myProfilePage = (MyProfilePage) loginPage.clickOnLoginButton(true);
        myProfilePage.sleepInSeconds(2);
        String myUsernameInHeader = myProfilePage.getMyProfileUsername();
        Assert.assertEquals(myUsernameInHeader, Const.USERNAME_REGISTERED_USER);
    }

    @Test
    public void testLoginUserHasValidPersonalInfoDisplayedInMenu() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.enterUsername(Const.EMAIL_REGISTERED_USER);
        loginPage.enterPassword(Const.PASS_REGISTERED_USER);
        MyProfilePage myProfilePage = (MyProfilePage) loginPage.clickOnLoginButton(true);
        myProfilePage.clickOnMyProfileIcon();
        String myUsernameFromMenu = myProfilePage.getMyProfileUsernameFromMenu();
        String myEmailFromMenu = myProfilePage.getMyProfileEmailFromMenu();
        Assert.assertTrue(myUsernameFromMenu.contains(Const.USERNAME_REGISTERED_USER));
        Assert.assertTrue(myEmailFromMenu.contains(Const.EMAIL_REGISTERED_USER));
    }

    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.enterUsername(Const.EMAIL_REGISTERED_USER);
        loginPage.enterPassword(Const.PASS_REGISTERED_USER);
        MyProfilePage myProfilePage = (MyProfilePage) loginPage.clickOnLoginButton(true);
        myProfilePage.clickOnMyProfileIcon();
        myProfilePage.sleepInSeconds(2);
        myProfilePage.logout();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(Const.LOGIN_PAGE_URL));
    }
}
