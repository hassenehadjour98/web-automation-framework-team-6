package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.GenerateData;
import utility.ReadFromExcel;

public class ForgotPasswordTest extends CommonAPI {
    Logger log = LogManager.getLogger(ForgotPasswordTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","ForgotPasswordTest");
    String validEmail = GenerateData.email(), password = GenerateData.password();
    String expectedNotificationEmailSent = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedNotificationEmailSent");
    String expectedNotificationEmailNotFound = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedNotificationEmailNotFound");
    String expectedCredentialsIncorrectMessage = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedCredentialsIncorrectMessage");
    RegistrationPage registrationPage;
    PasswordRecoveryPage passwordRecoveryPage;
    LogInPageNop logInPageNop;
    HomePage homePage;

    //Demo website requires to create an account before testing.
    @Test
    public void createAccount () {
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        String expectedRegisterPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","register page");
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle, "Did not land on registration page");
        log.info("Landed on registration page successfully");

        //Entering Credentials
        registrationPage = new RegistrationPage(getDriver());
        String firstName = GenerateData.firstName();
        registrationPage.setFirstName(firstName);
        String lastName = GenerateData.lastName();
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(validEmail);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);

        registrationPage.clkOnRegister();

        String returnedMessage = registrationPage.readReturnedMessage();
        String msgRegistrationSuccess = "Your registration completed";
        Assert.assertEquals(returnedMessage, msgRegistrationSuccess);
        log.info("Registration success message returned");
    }


    //Forgot password test with valid email
    @Test(priority = 0, dependsOnMethods = {"createAccount"})
    public void forgotPasswordWithValidEmailTest () {
        log.info("***  Forgot Password Test forgotPasswordWithValidEmailTest started ***");
//        1. Click on 'LogIn Link' in home page
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
//        2. click on forgot password link
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.forgotPassword();
        String actualTitle = getCurrentTitle();
        String expectedPasswordRecoveryPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","password recovery page");
        Assert.assertEquals(actualTitle,expectedPasswordRecoveryPageTitle);
        log.info("landed on password recovery page successfully");
//        2. Enter valid email address
//        3. Click on 'Recover' button
        passwordRecoveryPage = new PasswordRecoveryPage(getDriver());
        passwordRecoveryPage.recoverPassword(validEmail);

        String actualNotificationMessage = passwordRecoveryPage.getNotificationMessage();
        Assert.assertEquals(actualNotificationMessage,expectedNotificationEmailSent);
        log.info("Password recovery email sent successfully");
        log.info("***  Forgot Password Test forgotPasswordWithValidEmailTest finished ***");
    }

    //login with old password after password recovery
    @Test(priority = 1, dependsOnMethods = {"createAccount"})
    public void logInWithOldPasswordAfterPasswordRecoveryTest () throws InterruptedException {
        log.info("***  Forgot Password Test logInWithOldPasswordAfterPasswordRecoveryTest started ***");
//        1. Click on 'LogIn Link' in home page
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
//        2. click on forgot password link
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.forgotPassword();
        String actualTitle = getCurrentTitle();
        String expectedPasswordRecoveryPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","password recovery page");
        Assert.assertEquals(actualTitle,expectedPasswordRecoveryPageTitle);
        log.info("landed on password recovery page successfully");
//        2. Enter valid email address
//        3. Click on 'Recover' button
        passwordRecoveryPage = new PasswordRecoveryPage(getDriver());
        passwordRecoveryPage.recoverPassword(validEmail);

        String actualNotificationMessage = passwordRecoveryPage.getNotificationMessage();
        Assert.assertEquals(actualNotificationMessage,expectedNotificationEmailSent);
        log.info("Password recovery email sent successfully");
        passwordRecoveryPage.closeNotification();
//        homePage.waitForLogInLinkVisibility(getDriver(),5);
        Thread.sleep(1000);
        homePage.clkOnLinkLogin();
        logInPageNop.logIn(validEmail,password);
        String actualPageTitle = getCurrentTitle();
        String expectedLogInPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title", "login page");
        Assert.assertEquals(actualPageTitle,expectedLogInPageTitle);
        log.info("Stayed on LogIn page successfully");
        String actualMessageLogInError = logInPageNop.getMessageLogInError();
        Assert.assertEquals(actualMessageLogInError,expectedCredentialsIncorrectMessage);
        log.info("'The credentials provided are incorrect' Message Returned");

        log.info("***  Forgot Password Test logInWithOldPasswordAfterPasswordRecoveryTest finished ***");
        Thread.sleep(1000);
    }


    @DataProvider(name="invalidEmail")
    public Object[][] getInvalidData(){
        Object [][] data ={
                {GenerateData.email()},
                {GenerateData.email()},
                {GenerateData.email()},
                {GenerateData.email()},
                {GenerateData.email()}
        };
        return data;
    }
    //Forgot password test with invalid email
    @Test(priority = 2, dependsOnMethods = {"createAccount"}, dataProvider = "invalidEmail")
    public void forgotPasswordForNonRegisteredAccountTest (String invalidEmail) {
        log.info("***  Forgot Password Test forgotPasswordForNonRegisteredAccountTest started ***");
//        1. Click on 'LogIn Link' in home page
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
//        2. click on forgot password link
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.forgotPassword();
        String actualTitle = getCurrentTitle();
        String expectedPasswordRecoveryPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","password recovery page");
        Assert.assertEquals(actualTitle,expectedPasswordRecoveryPageTitle);
        log.info("landed on password recovery page successfully");

//        2. Enter invalid email address
//        3. Click on 'Recover' button
        passwordRecoveryPage = new PasswordRecoveryPage(getDriver());
        passwordRecoveryPage.recoverPassword(invalidEmail);
        String actualNotificationMessage = passwordRecoveryPage.getNotificationMessage();
        Assert.assertEquals(actualNotificationMessage,expectedNotificationEmailNotFound);
        log.info("email not found message returned successfully");
        log.info("***  Forgot Password Test forgotPasswordForNonRegisteredAccountTest finished ***");
    }
}
