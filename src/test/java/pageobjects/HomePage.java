package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='left-header-menu']")
    WebElement leftHeaderMenuButton;

    @FindBy(css = "div.left-header-menu.opened")
    WebElement leftHeaderMenu;

    @FindBy(xpath = "(//a[@href='/postavite-oglas'])[2]")
    WebElement submitAd;

    @FindBy(xpath = "//a[@href='/profil/omiljeni']")
    WebElement favoriteAds;

    @FindBy(xpath = "//a[@href='/prijava?returnUrl=%2f']")
    WebElement login;

    @FindBy(id = "search-query")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='direct-search']")
    WebElement searchButton;

    @FindBy(xpath = "//section[@role='contentinfo']")
    WebElement categories;

    @FindBy(xpath = "//p[@class='cookie-policy-text']")
    WebElement cookiePolicyText;

    @FindBy(xpath = "//p[@class='cookie-policy-btn']")
    WebElement cookiesOkBtn;

    @FindBy(xpath = "//div[@class = 'ad-faceting-result-count']/em")
    WebElement foundResults;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void expandLeftHeaderMenu(){
        clickOnElement(leftHeaderMenuButton);
    }

    public boolean isLeftHeaderMenuExpanded(){
        boolean isExpanded = false;
        if (isElementPresent(leftHeaderMenu)) {
            isExpanded = true;
        }
        return isExpanded;
    }

    public void enterSearchParam(String search) {
        enterTextToField(searchField, search);
    }

    public void clickSearch(){
        clickOnElement(searchButton);
    }

    private List<WebElement> getVisibleSearchResults(){
        List<WebElement> searchResults;
        String cssLocatorString = "span.on-map";
        searchResults = driver.findElements(By.cssSelector(cssLocatorString));
        return searchResults;
    }

    public int getSearchItemsNumber(){
        int results = getVisibleSearchResults().size();
        return results;
    }

    public LoginPage clickLoginIcon(){
        clickOnElement(login);
        return new LoginPage(driver);
    }

    public void clickPostAd(){
        clickOnElement(submitAd);
    }

    public void clickFavoriteAds(){
        clickOnElement(favoriteAds);
    }

    public boolean isCategoryContainerPresent(){
        boolean isPresent = false;
        if (isElementPresent(categories)) {
            isPresent = true;
        }
        return isPresent;
    }

    public boolean isCookieTextPresent(){
        boolean isPresent = false;
        if (isElementPresent(cookiePolicyText)) {
            isPresent = true;
        }
        return isPresent;
    }


    public String getCookieText(){
        String text = getTextFromWebElement(cookiePolicyText);
        return text;
    }

    public boolean isOkCookieButtonPresent(){
        boolean isPresent = false;
        if (isElementPresent(cookiesOkBtn)) {
            isPresent = true;
        }
        return isPresent;
    }

    public void clickOkCookieButton(){
        clickOnElement(cookiesOkBtn);
    }

    public int getFoundResultNumber(){
        String results = getTextFromWebElement(foundResults);
        return Integer.parseInt(results);
    }
}
