package testcase;

import base.BaseTest;
import constants.Const;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyProfilePage;
import util.RandomUtil;

public class LoginPageTests extends BaseTest {

    @Test
    public void testUserIsAbleToNavigateToLoginPage() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        Assert.assertTrue(loginPage.isLoginContainerPresent());
        Assert.assertTrue(loginPage.getUrlOfCurrentPage().contains(Const.LOGIN_PAGE_URL));
    }

    @Test
    public void testVerifyLabels() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        Assert.assertEquals(Const.LOGIN_TITLE, loginPage.getTextLoginPageTitle());
        Assert.assertEquals(Const.USERNAME_LABEL, loginPage.getUsernameFiledLabel());
        Assert.assertEquals(Const.PASSWORD_LABEL, loginPage.getPasswordFiledTLabel());
        Assert.assertEquals(Const.REMEMBER_ME_LABEL, loginPage.getRememberMeLabel());
        Assert.assertEquals(Const.FORGOT_PASSWORD_LABEL, loginPage.getForgotPasswordLabel());
    }

    @Test
    public void testValidLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.enterUsername(Const.EMAIL_REGISTERED_USER);
        loginPage.enterPassword(Const.PASS_REGISTERED_USER);
        MyProfilePage myProfilePage = (MyProfilePage) loginPage.clickOnLoginButton(true);
        Assert.assertTrue(myProfilePage.getUrlOfCurrentPage().contains(Const.MY_PROFILE_PAGE_URL));
    }

    @Test
    public void testWrongEmailLogin() {
        String username = RandomUtil.createRandomEmail();
        String expectedErrorMsg = Const.LOGIN_ERROR_MSG;
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.enterUsername(username);
        loginPage.enterPassword(Const.PASS_REGISTERED_USER);
        loginPage.clickOnLoginButton(false);
        String actualErrorMsg = loginPage.getErrorMsg();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testWrongPasswordLogin() {
        String password = RandomUtil.createRandomPassword();
        String expectedErrorMsg = Const.LOGIN_ERROR_MSG;
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.enterUsername(Const.EMAIL_REGISTERED_USER);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton(false);
        String actualErrorMsg = loginPage.getErrorMsg();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testLoginViaGoogleButton() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.clickOnLoginGoogleButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(Const.GOOGLE_LOGIN));
    }

    @Test
    public void testLoginViaFacebookButton() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.clickOnLoginFacebookButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(Const.FACEBOOK_LOGIN));
    }
}
