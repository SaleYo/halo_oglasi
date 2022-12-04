package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;
    protected static final int WAIT_TIMEOUT = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void navigateToUrl(String url) {
        driver.get(url);
    }

    protected void enterTextToField(WebElement element, String text){
        element.clear();
        element.click();
        element.sendKeys(text);
    }

    protected void clickOnElement(WebElement element){
        if (isElementPresent(element)) {
            element.click();
        }
    }
    public static String getTextFromWebElement(WebElement webElement) {
        return webElement.getText();
    }

    public static boolean isElementPresent(WebElement element) {
        boolean isPresent = false;
        if (element.isEnabled() && element.isDisplayed()) {
            isPresent = true;
        }
        return isPresent;
    }

    public static boolean isElementSelected(WebElement element) {
        boolean isSelected = false;
        if (element.isSelected()){
            isSelected = true;
        }
      return isSelected;
    }

    public String getUrlOfCurrentPage(){
        String url = driver.getCurrentUrl();
        return url;
    }

    public static String trimAstrixFromLabel(String text) {
        return text.replace("*", "");
    }

    public void sleepInSeconds(int sec){
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
