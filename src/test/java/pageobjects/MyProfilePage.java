package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage{

    @FindBy(css = "p.header-user-name")
    WebElement myProfileUsername;

    @FindBy(xpath = "//div[contains(@class,'logged-in-wrapper')]/a")
    WebElement myProfileIcon;

    @FindBy(css = ".header-category-link.opened")
    WebElement myProfileInfoMenu;

    @FindBy(xpath = "(//p[@class='user-email'])[1]")
    WebElement emailFromProfileMenu;

    @FindBy(xpath = "(//p[@class='user-username'])[1]")
    WebElement usernameFromProfileMenu;

    @FindBy(xpath = "(//a[@class='user-logout-link'])[1]")
    WebElement logoutLink;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getMyProfileUsername(){
        String username = getTextFromWebElement(myProfileUsername);
        return username;
    }

    public void clickOnMyProfileIcon(){
        clickOnElement(myProfileIcon);
    }

    public boolean isMyProfileMenuExpanded(){
       boolean isExpanded = false;
       if (isElementPresent(myProfileInfoMenu)){
           isExpanded = true;
       }
       return isExpanded;
    }

    public String getMyProfileUsernameFromMenu(){
        String username = getTextFromWebElement(usernameFromProfileMenu);
        return username;
    }

    public String getMyProfileEmailFromMenu(){
        String email = getTextFromWebElement(emailFromProfileMenu);
        return email;
    }

    public void logout(){
        clickOnElement(logoutLink);
    }
}
