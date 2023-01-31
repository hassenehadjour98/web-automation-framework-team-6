package nopcommerce.tests;

import base.CommonAPI;
import com.github.javafaker.Faker;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.LogInPageNop;
import nopcommerce.pages.MyAccountPage;
import nopcommerce.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogOutTest.class.getName());
    String expRegisterPageTitle = "nopCommerce demo store. Register";
    String msgRegistrationSuccess = "Your registration completed";
    String expectedMyAccountLinkText = "My account";
    String expectedLogInLinkText = "Log in";
    Faker faker = new Faker();
    String firstName = faker.name().firstName() ,lastName = faker.name().lastName();
    String validEmail = faker.internet().emailAddress(), validPassword = faker.internet().password();
    RegistrationPage registrationPage;
    LogInPageNop logInPageNop;
    HomePage homePage;
    MyAccountPage myAccountPage;
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
    @Test(priority = 4, dependsOnMethods = {"createAccount"})
    public void logInAndLogOut () {
        log.info("***  Log in Test logInAndLogOut started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");

        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        myAccountPage = new MyAccountPage(getDriver());
        String actualMyAccountLinkText = myAccountPage.getMyAccountLinkText();
        Assert.assertEquals(actualMyAccountLinkText,expectedMyAccountLinkText);
        log.info("Logged in successfully");
        myAccountPage.logOut();
        String actualLogInLinkText = homePage.getLogInLinkText();
        Assert.assertEquals(actualLogInLinkText,expectedLogInLinkText);
        log.info("Logged out successfully");

        log.info("***  Log in Test logInAndLogOut finished ***");
    }
}
