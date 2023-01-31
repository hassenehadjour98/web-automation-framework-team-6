package nopcommerce.tests;


import base.CommonAPI;
import com.github.javafaker.Faker;
import nopcommerce.pages.MyAccountPage;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.LogInPageNop;
import nopcommerce.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogInTest.class.getName());
    String expRegisterPageTitle = "nopCommerce demo store. Register";
    String msgRegistrationSuccess = "Your registration completed";
    String expectedMyAccountLinkText = "My account";
    String expectedLogInLinkText = "Log in";
    String expectedCredentialsIncorrectMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "The credentials provided are incorrect";
    String expectedNoAccountFoundMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    Faker faker = new Faker();
    String firstName = faker.name().firstName() ,lastName = faker.name().lastName();
    String validEmail = faker.internet().emailAddress(), validPassword = faker.internet().password();
    String invalidEmail = faker.internet().emailAddress(), invalidPassword =faker.internet().password();
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
        Assert.assertEquals(actualTitle, expRegisterPageTitle, "Did not land on registration page");
        log.info("Landed on registration page successfully");

        //Entering Credentials
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(validEmail);
        registrationPage.setPassword(validPassword);
        registrationPage.setConfirmPassword(validPassword);

        registrationPage.clkOnRegister();

        String returnedMessage = registrationPage.readReturnedMessage();
            Assert.assertEquals(returnedMessage, msgRegistrationSuccess);
            log.info("Registration success message returned");
    }


    //Test Validate logging with valid credentials
    @Test(priority = 0, dependsOnMethods = {"createAccount"})
    public void logInWithValidCredentials () {
        log.info("***  Log in Test logInWithValidCredentials started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");

        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        myAccountPage = new MyAccountPage(getDriver());
        String actualMyAccountLinkText = myAccountPage.getMyAccountLinkText();
        Assert.assertEquals(actualMyAccountLinkText,expectedMyAccountLinkText);
        log.info("Logged in successfully");
        log.info("***  Log in Test logInWithValidCredentials finished ***");
    }
    //Test Login with valid email and invalid password
    @Test (priority = 1, dependsOnMethods = {"createAccount"})
    public void logInWithValidEmailAndInvalidPassword() {
        log.info("***  Log in Test logInWithValidEmailAndInvalidPassword started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail, invalidPassword);
        String actualMessageLogInError = logInPageNop.getMessageLogInError();
        Assert.assertEquals(actualMessageLogInError,expectedCredentialsIncorrectMessage);
        log.info("'The credentials provided are incorrect' Message Returned");
        log.info("***  Log in Test logInWithValidEmailAndInvalidPassword finished ***");
    }
    //Test Login with invalid email and valid password
    @Test (priority = 2, dependsOnMethods = {"createAccount"})
    public void logInWithInvalidEmailAndValidPassword () {
        log.info("***  Log in Test logInWithInvalidEmailAndValidPassword started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(invalidEmail, validPassword);
        String actualMessageLogInError = logInPageNop.getMessageLogInError();
        Assert.assertEquals(actualMessageLogInError, expectedNoAccountFoundMessage);
        log.info("'No customer account found' message Returned");
        log.info("***  Log in Test logInWithInvalidEmailAndValidPassword finished ***");
    }
    //Test Login with invalid email and invalid password
    @Test (priority = 3, dependsOnMethods = {"createAccount"})
    public void logInWithInvalidEmailAndInvalidPassword() {
        log.info("***  Log in Test logInWithInvalidEmailAndInvalidPassword started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(invalidEmail, invalidPassword);
        String actualMessageLogInError = logInPageNop.getMessageLogInError();
        Assert.assertEquals(actualMessageLogInError, expectedNoAccountFoundMessage);
        log.info("'No customer account found' message Returned");
        log.info("***  Log in Test logInWithInvalidEmailAndInvalidPassword finished ***");
    }

}
