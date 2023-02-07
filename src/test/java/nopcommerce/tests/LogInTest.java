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

public class LogInTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogInTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","LogInTest");

    String expectedLogInPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title", "login page");
    String expectedCredentialsIncorrectMessage = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedCredentialsIncorrectMessage");
    String expectedNoAccountFoundMessage = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedNoAccountFoundMessage");
    String expectedMyAccountLinkText = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedMyAccountLinkText");


    String validEmail = GenerateData.email(), validPassword = GenerateData.password();
    String invalidEmail = GenerateData.email();
    RegistrationPage registrationPage;
    LogInPageNop logInPageNop;
    HomePage homePage;
    MyAccountPage myAccountPage;



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
        registrationPage.setPassword(validPassword);
        registrationPage.setConfirmPassword(validPassword);

        registrationPage.clkOnRegister();

        String returnedMessage = registrationPage.readReturnedMessage();
        String msgRegistrationSuccess = "Your registration completed";
            Assert.assertEquals(returnedMessage, msgRegistrationSuccess);
            log.info("Registration success message returned");
    }


    //Test Validate logging with valid credentials
    @Test(priority = 0, dependsOnMethods = {"createAccount"})
    public void logInWithValidCredentials () {
        log.info("***  Log in Test logInWithValidCredentials started ***");
//        1. Click on 'LogIn Link' in home page
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedLogInPageTitle);

        log.info("Landed on login page success");
//        2. Enter valid email address
//        3. Enter valid password into the 'Password' field
//        4. Click on 'Login' button
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        myAccountPage = new MyAccountPage(getDriver());
        String actualMyAccountLinkText = myAccountPage.getMyAccountLinkText();
        Assert.assertEquals(actualMyAccountLinkText,expectedMyAccountLinkText);

        log.info("Logged in successfully");
        log.info("***  Log in Test logInWithValidCredentials finished ***");
    }

    @DataProvider (name="validEmailInvalidPasswordsData")
    public Object[][] getData(){
        Object [][] data ={
                {validEmail,GenerateData.password()},
                {validEmail,GenerateData.password()},
                {validEmail,GenerateData.password()},
                {validEmail,GenerateData.password()},
                {validEmail,GenerateData.password()}
        };
        return data;
    }
    //Test Login with valid email and invalid password
    @Test (priority = 1, dependsOnMethods = {"createAccount"}, dataProvider = "validEmailInvalidPasswordsData")
    public void logInWithValidEmailAndInvalidPassword(String validEmail, String invalidPassword) {
        log.info("***  Log in Test logInWithValidEmailAndInvalidPassword started ***");
//        1. Click on 'LogIn Link' in home page
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedLogInPageTitle);
        log.info("Landed on login page success");
//        2. Enter valid email address
//        3. Enter invalid password into the 'Password' field
//        4. Click on 'Login' button
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail, invalidPassword);
        String actualMessageLogInError = logInPageNop.getMessageLogInError();
        Assert.assertEquals(actualMessageLogInError,expectedCredentialsIncorrectMessage);
        log.info("'The credentials provided are incorrect' Message Returned");
        String actTitle = getCurrentTitle();
        Assert.assertEquals(actTitle,expectedLogInPageTitle);
        log.info("Stayed on login page success");
        log.info("***  Log in Test logInWithValidEmailAndInvalidPassword finished ***");
    }


    //Test Login with invalid email and valid password
    @Test (priority = 2, dependsOnMethods = {"createAccount"})
    public void logInWithInvalidEmailAndValidPassword () {
        log.info("***  Log in Test logInWithInvalidEmailAndValidPassword started ***");
        //        1. Click on 'LogIn Link' in home page
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedLogInPageTitle);
        log.info("Landed on login page success");
//        2. Enter invalid email address
//        3. Enter valid password into the 'Password' field
//        4. Click on 'Login' button
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(invalidEmail, validPassword);
        String actualMessageLogInError = logInPageNop.getMessageLogInError();
        Assert.assertEquals(actualMessageLogInError, expectedNoAccountFoundMessage);
        log.info("'No customer account found' message Returned");
        String actTitle = getCurrentTitle();
        Assert.assertEquals(actTitle,expectedLogInPageTitle);
        log.info("Stayed on login page success");
        log.info("***  Log in Test logInWithInvalidEmailAndValidPassword finished ***");
    }

    @DataProvider (name="invalidCredentialsData")
    public Object[][] getInvalidData(){
        Object [][] data ={
                {GenerateData.email(),GenerateData.password()},
                {GenerateData.email(),GenerateData.password()},
                {GenerateData.email(),GenerateData.password()},
                {GenerateData.email(),GenerateData.password()},
                {GenerateData.email(),GenerateData.password()}
        };
        return data;
    }
    //Test Login with invalid email and invalid password
    @Test (priority = 3, dataProvider = "invalidCredentialsData")
    public void logInWithInvalidEmailAndInvalidPassword(String invalidEmail, String invalidPassword) {
        log.info("***  Log in Test logInWithInvalidEmailAndInvalidPassword started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedLogInPageTitle);
        log.info("Landed on login page success");
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(invalidEmail, invalidPassword);
        String actualMessageLogInError = logInPageNop.getMessageLogInError();
        Assert.assertEquals(actualMessageLogInError, expectedNoAccountFoundMessage);
        log.info("'No customer account found' message Returned");
        String actTitle = getCurrentTitle();
        Assert.assertEquals(actTitle,expectedLogInPageTitle);
        log.info("Stayed on login page success");
        log.info("***  Log in Test logInWithInvalidEmailAndInvalidPassword finished ***");
    }


}
