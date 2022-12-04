package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    @FindBy(css= "div.registration-container")
    WebElement registrationContainer;

    @FindBy(xpath = "//div[@class='registration-title']")
    WebElement registrationTitle;

    @FindBy(xpath = "//input[@value='person']")
    WebElement radioButtonPerson;

    @FindBy(xpath = "//input[@value='company']")
    WebElement radioButtonCompany;

    @FindBy(xpath = "//label[@for='UserName']")
    WebElement usernameLabel;

    @FindBy(id = "UserName")
    WebElement usernameField;

    @FindBy(xpath = "//label[@for='Email']")
    WebElement emailLabel;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(xpath = "//label[@for='Password']")
    WebElement passwordLabel;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//label[@for='ConfirmPassword']")
    WebElement confirmPasswordLabel;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//label[@for='AllowSendingNewsletters']")
    WebElement allowSendingNewslettersLabel;

    @FindBy(id = "AllowSendingNewslettersLabel")
    WebElement allowSendingNewslettersLabelCheckbox;

    @FindBy(xpath = "//label[@for='HasAgreedToGetFiscalReceiptByEmail']")
    WebElement hasAgreedToGetFiscalReceiptByEmailLabel;

    @FindBy(id = "HasAgreedToGetFiscalReceiptByEmail")
    WebElement hasAgreedToGetFiscalReceiptByEmailCheckbox;

    @FindBy(css = "button.save-entity.person-face")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='jquery-notific8-message']")
    WebElement message;

    @FindBy(xpath = "//div[@class='regsitration-success']")
    WebElement registrationText;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegistrationContainerPresent(){
       boolean isPresent = false;
       if (isElementPresent(registrationContainer)){
           isPresent = true;
       }
       return isPresent;
    }

    public void enterUsername(String username){
        enterTextToField(usernameField, username);
    }

    public void enterEmail(String email){
        enterTextToField(emailField, email);
    }

    public void enterPassword(String password){
        enterTextToField(passwordField, password);
    }

    public void enterConfirmPassword(String password){
        enterTextToField(confirmPasswordField, password);
    }

    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
    }

    public void selectPersonRadioButton(){
        if (!isElementPresent(radioButtonPerson)){
            clickOnElement(radioButtonPerson);
        }
    }

    public boolean isPersonRadioButtonSelected(){
        boolean isSelected = false;
        if (isElementSelected(radioButtonPerson)) {
            isSelected = true;
        }
        return isSelected;
    }

    public boolean isCompanyRadioButtonSelected(){
        boolean isSelected = false;
        if (isElementSelected(radioButtonCompany)) {
            isSelected = true;
        }
        return isSelected;
    }

    public String getRegistrationTitle(){
        String title = getTextFromWebElement(registrationTitle);
        return title;
    }

    public String getUsernameLabel(){
        String label = getTextFromWebElement(usernameLabel);
        return trimAstrixFromLabel(label);
    }

    public String getEmailLabel(){
        String label = getTextFromWebElement(emailLabel);
        return trimAstrixFromLabel(label);
    }

    public String getPasswordLabel(){
        String label = getTextFromWebElement(passwordLabel);
        return trimAstrixFromLabel(label);
    }

    public String getConfirmPasswordLabel(){
        String label = getTextFromWebElement(confirmPasswordLabel);
        return trimAstrixFromLabel(label);
    }

    public String getAllowSendingNewslettersLabel(){
        String label = getTextFromWebElement(allowSendingNewslettersLabel);
        return label;
    }

    public String getHasAgreedToGetFiscalReceiptByEmailLabel(){
        String label = getTextFromWebElement(hasAgreedToGetFiscalReceiptByEmailLabel);
        return trimAstrixFromLabel(label);
    }

    public boolean isAllowSendingNewslettersCheckboxSelected(){
        return isElementSelected(allowSendingNewslettersLabelCheckbox);
    }
    
    public void checkAllowSendingNewslettersCheckbox() {
        if (!isAllowSendingNewslettersCheckboxSelected()){
                clickOnElement(allowSendingNewslettersLabelCheckbox);
        }
    }

    public boolean isHasAgreedToGetFiscalReceiptByEmailCheckboxSelected(){
        return isElementSelected(hasAgreedToGetFiscalReceiptByEmailCheckbox);
    }

    public void checkHasAgreedToGetFiscalReceiptByEmailCheckbox() {
        if (!isHasAgreedToGetFiscalReceiptByEmailCheckboxSelected()){
            clickOnElement(hasAgreedToGetFiscalReceiptByEmailCheckbox);
        }
    }

    public String getMessage(){
        String msg = getTextFromWebElement(message);
        return msg;
    }

    public String getRegistrationTextFromContainer(){
        String text = getTextFromWebElement(registrationText);
        return text;
    }


}
