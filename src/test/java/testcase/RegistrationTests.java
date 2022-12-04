package testcase;

import base.BaseTest;
import constants.Const;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import util.RandomUtil;

public class RegistrationTests extends BaseTest {

    @Test
    public void testUserIsAbleToNavigateToRegistrationPage() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        loginPage.clickOnRegisterLink();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(Const.REGISTRATION_PAGE_URL));
    }

    @Test
    public void testRegisterContainerIsAvailable() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.isRegistrationContainerPresent();
    }

    @Test
    public void testVerifyLabels() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        Assert.assertEquals(Const.REGISTRATION_TITLE, registrationPage.getRegistrationTitle());
        Assert.assertEquals(Const.REG_USERNAME_LABEL, registrationPage.getUsernameLabel());
        Assert.assertEquals(Const.REG_EMAIL_LABEL, registrationPage.getEmailLabel());
        Assert.assertEquals(Const.REG_PASSWORD_LABEL, registrationPage.getPasswordLabel());
        Assert.assertEquals(Const.REG_CONFIRM_PASSWORD_LABEL, registrationPage.getConfirmPasswordLabel());
        Assert.assertEquals(Const.REG_HAS_AGREED_TO_SEND_FINANCIAL_LABEL, registrationPage.getHasAgreedToGetFiscalReceiptByEmailLabel());
        Assert.assertEquals(Const.REG_ALLOW_SENDING_NEWS_LABEL, registrationPage.getAllowSendingNewslettersLabel());
    }

    @Test
    public void testPersonIsSelectedByDefault() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        Assert.assertTrue(registrationPage.isPersonRadioButtonSelected());
    }

    @Test
    public void testExistingUserNameIsProvided() {
        String expectedErrorMsg = Const.EXISTING_USER_ERROR_MSG;
        String email = RandomUtil.createRandomEmail();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(email);
        registrationPage.enterUsername(Const.USERNAME_REGISTERED_USER);
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword(Const.PASS_REGISTERED_USER);
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testExistingEmailIsProvided() {
        String expectedErrorMsg = Const.EXISTING_USER_ERROR_MSG;
        String username = RandomUtil.createRandomUsername();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(Const.EMAIL_REGISTERED_USER);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword(Const.PASS_REGISTERED_USER);
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testEmptyEmailIsProvided() {
        String expectedErrorMsg = Const.EMPTY_EMAIL_ERROR_MSG;
        String username = RandomUtil.createRandomUsername();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail("");
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword(Const.PASS_REGISTERED_USER);
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }
    @Test
    public void testEmptyUsernameProvided() {
        String expectedErrorMsg = Const.EMPTY_USERNAME_ERROR_MSG;
        String email = RandomUtil.createRandomEmail();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(email);
        registrationPage.enterUsername("");
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword(Const.PASS_REGISTERED_USER);
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testEmptyPasswordProvided() {
        String expectedErrorMsg = Const.EMPTY_PASS_ERROR_MSG;
        String username = RandomUtil.createRandomUsername();
        String email = RandomUtil.createRandomEmail();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(email);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword("");
        registrationPage.enterConfirmPassword(Const.PASS_REGISTERED_USER);
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testEmptyConfirmationPasswordProvided() {
        String expectedErrorMsg = Const.EMPTY_CONFIRM_PASS_ERROR_MSG;
        String username = RandomUtil.createRandomUsername();
        String email = RandomUtil.createRandomEmail();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(email);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword("");
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testPasswordsNotMatchProvided() {
        String expectedErrorMsg = Const.DIFFERENT_PASS_ERROR_MSG;
        String username = RandomUtil.createRandomUsername();
        String email = RandomUtil.createRandomEmail();
        String pass = RandomUtil.createRandomPassword();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(email);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword(pass);
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testAgreedToGetFiscalReceiptByEmailNotChecked() {
        String expectedErrorMsg = Const.NOT_ACCEPTED_TO_RECEIVE_RECEIPT_ERROR_MSG;
        String username = RandomUtil.createRandomUsername();
        String email = RandomUtil.createRandomEmail();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(email);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword(Const.PASS_REGISTERED_USER);
        registrationPage.clickOnRegisterButton();
        String actualErrorMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test
    public void testSuccessfulRegistration() {
        String expectedSuccessRegistrationMsg = Const.REG_SUCCESSFUL_MSG;
        String username = RandomUtil.createRandomUsername();
        String email = RandomUtil.createRandomEmail();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginIcon();
        RegistrationPage registrationPage = loginPage.clickOnRegisterLink();
        registrationPage.enterEmail(email);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(Const.PASS_REGISTERED_USER);
        registrationPage.enterConfirmPassword(Const.PASS_REGISTERED_USER);
        registrationPage.checkHasAgreedToGetFiscalReceiptByEmailCheckbox();
        registrationPage.clickOnRegisterButton();
        String actualSuccessRegistrationMsg = registrationPage.getMessage();
        Assert.assertEquals(expectedSuccessRegistrationMsg, actualSuccessRegistrationMsg);
    }
}
