package nopcommerce.tests;

import base.CommonAPI;
import com.github.javafaker.Faker;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationPageTest extends CommonAPI {
    Faker faker = new Faker();
    Logger log = LogManager.getLogger(RegistrationPageTest.class.getName());
    String firstName = "qa" ,lastName = "qa", dayOfBirth = "3", monthOfBirth = "July", yearOfBirth = "1962";
    String email = faker.internet().emailAddress(), companyName = "C/W Productions", password=faker.internet().password();
    String msgRegistrationSuccess ="Your registration completed";
    String msgEmailExists ="The specified email already exists";
    String expectedHomePageTitle = "nopCommerce demo store. Register";
    HomePage homePage;
    RegistrationPage registrationPage;
    @Test
    public void registerProvidingAllFieldsTest () {
        log.info("***  Registration Test registerProvidingAllFieldsTest Started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedHomePageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clkOnMale();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.selectDayOfBirth(dayOfBirth);
        registrationPage.selectMonthOfBirth(monthOfBirth);
        registrationPage.selectYearOfBirth(yearOfBirth);
        registrationPage.setEmail(email);
        registrationPage.setCompanyName(companyName);
        registrationPage.selectNewsletter();
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clkOnRegister();

        String returnedMessage = registrationPage.readReturnedMessage();
            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");
        log.info("Provided email: "+email);
        log.info("***  Registration Test registerProvidingAllFieldsTest finished ***");

    }
    @Test
    public void registerWithRegisteredEmailTest () {
        log.info("***  Registration Test registerWithRegisteredEmailTest Started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedHomePageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clkOnMale();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.selectDayOfBirth(dayOfBirth);
        registrationPage.selectMonthOfBirth(monthOfBirth);
        registrationPage.selectYearOfBirth(yearOfBirth);
        registrationPage.setEmail(email);
        registrationPage.setCompanyName(companyName);
        registrationPage.selectNewsletter();
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clkOnRegister();

        String returnedMessage = registrationPage.readReturnedMessage();
        Assert.assertEquals(returnedMessage,msgEmailExists);
        log.info("Email exists message returned");
            String returnedEmail = registrationPage.registeredEmail();
            Assert.assertEquals(returnedEmail,email);
            log.info("Email matches registered user");
        log.info("Provided email: "+email);

        log.info("***  Registration Test registerWithRegisteredEmailTest finished ***");

    }
    @Test
    public void registerProvidingOnlyMandatoryFields () {
        log.info("***  Registration Test registerProvidingOnlyMandatoryFields Started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedHomePageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

        registrationPage = new RegistrationPage(getDriver());
        String email = faker.internet().emailAddress();

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clkOnRegister();

        String returnedMessage = registrationPage.readReturnedMessage();

            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");
            log.info("Provided email: "+email);

        log.info("***  Registration Test registerProvidingOnlyMandatoryFields finished ***");

    }
    @Test
    public void registerWithoutProvidingAnyData () {
        log.info("***  Registration Test registerWithoutProvidingAnyData Started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedHomePageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

        registrationPage = new RegistrationPage(getDriver());

        registrationPage.clkOnRegister();

        String actFNameMsg = registrationPage.getFNameReqMsg();
        String actLNameMsg = registrationPage.getLNameReqMsg();
        String actEmailMsg = registrationPage.getEmailReqMsg();
        String actPasswordMsg = registrationPage.getPasswordReqMsg();
        String actPasswordConfMsg = registrationPage.getPasswordConfReqMsg();

        String expFNameMsg = "First name is required.";
        String expLNameMsg = "Last name is required.";
        String expEmailMsg = "Email is required.";
        String expPasswordMsg = "Password is required.";
        String expPasswordConfMsg = "Password is required.";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actFNameMsg,expFNameMsg);
        log.info("First name is required. msg displayed success");
        softAssert.assertEquals(actLNameMsg,expLNameMsg);
        log.info("Last name is required. msg displayed success");
        softAssert.assertEquals(actEmailMsg,expEmailMsg);
        log.info("Email is required. msg displayed success");
        softAssert.assertEquals(actPasswordMsg,expPasswordMsg);
        log.info("Password is required. msg displayed success");
        softAssert.assertEquals(actPasswordConfMsg,expPasswordConfMsg);
        log.info("Password is required. msg displayed success");
        softAssert.assertAll();
        log.info("***  Registration Test registerWithoutProvidingAnyData finished ***");

    }

}
