package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "divLogin")
    WebElement loginContainer;

    @FindBy(xpath = "//div[@class='login-title']")
    WebElement loginTitle;

    @FindBy(xpath = "//label[@for='EMailOrUsername']")
    WebElement emailOrUsernameTitle;

    @FindBy(xpath = "//label[@for='Password']")
    WebElement passwordTitle;

    @FindBy(id = "EMailOrUsername")
    WebElement usernameField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//a[@class='prevent']")
    WebElement forgotPassword;

    @FindBy(id = "remember-me")
    WebElement rememberMeCheckbox;

    @FindBy(xpath = "//label[@for='remember-me']")
    WebElement rememberMeTitle;

    @FindBy(xpath = "//button[contains(@class,'login-user')]")
    WebElement loginButton;

    @FindBy(id = "Google")
    WebElement loginWithGoogleButton;

    @FindBy(id = "Facebook")
    WebElement loginWithFacebookButton;

    @FindBy(xpath = "//a[@class='no-account-reg-link']")
    WebElement registerLink;

    @FindBy(xpath = "//div[@class='jquery-notific8-message']")
    WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        enterTextToField(usernameField, username);
    }

    public void enterPassword(String password){
        enterTextToField(passwordField, password);
    }

    public BasePage clickOnLoginButton(boolean validLogin){
        clickOnElement(loginButton);
        if(validLogin){
            return new MyProfilePage(driver);
        } else {
           return new LoginPage(driver);
        }
    }

    public void clickOnLoginGoogleButton(){
        clickOnElement(loginWithGoogleButton);
    }

    public void clickOnLoginFacebookButton(){
        clickOnElement(loginWithFacebookButton);
    }

    public boolean isLoginContainerPresent(){
        boolean isPresent = false;
        if (isElementPresent(loginContainer)){
            isPresent = true;
        }
        return isPresent;
    }

    public String getTextLoginPageTitle(){
        String title = getTextFromWebElement(loginTitle);
        return title;
    }

    public String getUsernameFiledLabel(){
        String label = getTextFromWebElement(emailOrUsernameTitle);
        return trimAstrixFromLabel(label);
    }

    public String getPasswordFiledTLabel(){
        String label = getTextFromWebElement(passwordTitle);
        return trimAstrixFromLabel(label);
    }

    public String getRememberMeLabel(){
        String label = getTextFromWebElement(rememberMeTitle);
        return label;
    }

    public String getForgotPasswordLabel(){
        String label = getTextFromWebElement(forgotPassword);
        return label;
    }

    public boolean isRememberMeCheckboxSelected(){
      return isElementSelected(rememberMeCheckbox);
    }

    public void selectRememberMeCheckboxSelected(){
        if (!isRememberMeCheckboxSelected()){
            clickOnElement(rememberMeCheckbox);
        }
    }

    public void clickOnForgetPasswordLink(){
        clickOnElement(forgotPassword);
    }

    public RegistrationPage clickOnRegisterLink(){
        clickOnElement(registerLink);
        return new RegistrationPage(driver);
    }

    public String getErrorMsg(){
        String msg = getTextFromWebElement(errorMsg);
        return msg;
    }
}
