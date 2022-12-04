package testcase;

import base.BaseTest;
import constants.Const;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class HomePageTests extends BaseTest {

    @Test
    public void testCookiesInfoIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isCookieTextPresent());
        Assert.assertTrue(homePage.isOkCookieButtonPresent());
    }

    @Test
    public void testVerifyCookiesInfoText() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(Const.COOKIE_TEXT, homePage.getCookieText());
    }

    @Test
    public void testAcceptCookies() {
        HomePage homePage = new HomePage(driver);
        boolean isCookiesTextPresentBefore = homePage.isCookieTextPresent();
        homePage.clickOkCookieButton();
        boolean isCookiesTextPresentAfter = homePage.isCookieTextPresent();
        Assert.assertNotEquals(isCookiesTextPresentBefore,isCookiesTextPresentAfter);
    }

    @Test
    public void testClickLHMIconExpandMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.expandLeftHeaderMenu();
        Assert.assertTrue(homePage.isLeftHeaderMenuExpanded());
    }

    @Test
    public void testSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchParam(Const.SEARCH_TERM);
        homePage.clickSearch();
        int numOfListedItems = homePage.getSearchItemsNumber();
        int displayedResults = homePage.getFoundResultNumber();
        Assert.assertEquals(numOfListedItems, displayedResults);
    }

    @Test
    public void clickOnLoginIcon(){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginIcon();
        String currentPageUrl = homePage.getUrlOfCurrentPage();
        Assert.assertTrue(currentPageUrl.contains(Const.LOGIN_PAGE_URL));
    }

    @Test
    public void clickOnPostAdd(){
        HomePage homePage = new HomePage(driver);
        homePage.clickPostAd();
        String currentPageUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentPageUrl.contains(Const.POST_AD_PAGE_URL));
    }
}
