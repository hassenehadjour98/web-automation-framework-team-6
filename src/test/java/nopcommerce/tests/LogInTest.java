package nopcommerce.tests;


import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.LogInPageNop;
import nopcommerce.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogInTest.class.getName());
    String expLogInPageTitle="nopCommerce demo store. Login";
    String expRegisterPageTitle = "nopCommerce demo store. Register";
    String firstName = "qa" ,lastName = "qa", email = "test@gmail.com", password = "123abc";
    RegistrationPage registrationPage;
    LogInPageNop lp;
    HomePage hp;
    @BeforeMethod
    public void navigateToLogInPage(){
        hp= new HomePage(getDriver());
        hp.clkOnLnkLogin();
        log.info("Landed on login page success");
    }

    //Demo website requires to create an account before testing.
    @Test (priority = 0)
    public void createAccount () {
        hp = new HomePage(getDriver());
        hp.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expRegisterPageTitle, "Did not land on registration page");
        log.info("Landed on registration page successfully");
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clkOnRegister();
        String msgRegistrationSuccess = "Your registration completed";
        String msgEmailExists = "The specified email already exists";

        String returnedMessage = registrationPage.readReturnedMessage();
        if (returnedMessage.equals(msgRegistrationSuccess)) {
            Assert.assertEquals(returnedMessage, msgRegistrationSuccess);
            log.info("Registration success message returned");
        } else if (returnedMessage.equals(msgEmailExists)) {
            String returnedEmail = registrationPage.registeredEmail();
            Assert.assertEquals(returnedEmail, email);
            log.info("Email exists message returned");
            log.info("Email matches registered user");
        }
    }


    //Login with valid email and password
    @Test(priority = 1, dependsOnMethods = {"createAccount"})
    public void logIn () {
        log.info("***  Log in Test 1 started ***");
        lp= new LogInPageNop(getDriver());
        lp.logIn(email,password);


        log.info("***  Log in Test 1 finished ***");
    }
    //Login with valid email and invalid password
    @Test (priority = 2, dependsOnMethods = {"createAccount"})
    public void logInTest2 () {
        log.info("***  Log in Test 2 started ***");
        hp= new HomePage(getDriver());
        hp.clkOnLnkLogin();
        lp = new LogInPageNop(getDriver());
        lp.logIn(email, password);
    }
}
