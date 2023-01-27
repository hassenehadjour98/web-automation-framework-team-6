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
    String firstName = "Tom" ,lastName = "Cruise", dayOfBirth = "3", monthOfBirth = "July", yearOfBirth = "1962";
    String email = faker.internet().emailAddress(), companyName = "C/W Productions", password="07031962";
    String msgRegistrationSuccess ="Your registration completed";
    String msgEmailExists ="The specified email already exists";
    @BeforeMethod
    public void navigateToRegisterPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");
    }
    RegistrationPage registrationPage;
    @Test
    public void registrationTest1 () {
        log.info("***  Registration Test 1 Started ***");

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
        if (returnedMessage.equals(msgRegistrationSuccess)){
            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");
        }

        else if (returnedMessage.equals(msgEmailExists)){
            String returnedEmail = registrationPage.registeredEmail();
            Assert.assertEquals(returnedEmail,email);
            log.info("Email exists message returned");
            log.info("Email matches registered user");
        }
        log.info("***  Registration Test 1 finished ***");

    }
    @Test
    public void registrationTest2 () {
        log.info("***  Registration Test 2 Started ***");

        registrationPage = new RegistrationPage(getDriver());
        String email = "tomcruise2@gmail.com";

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clkOnRegister();

        String returnedMessage = registrationPage.readReturnedMessage();
        if (returnedMessage.equals(msgRegistrationSuccess)){
            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");
        }

        else if (returnedMessage.equals(msgEmailExists)){
            String returnedEmail = registrationPage.registeredEmail();
            Assert.assertEquals(returnedEmail,email);
            log.info("Email exists message returned");
            log.info("Email matches registered user");
        }
        log.info("***  Registration Test 2 finished ***");

    }
    @Test
    public void registrationTest3 () {
        log.info("***  Registration Test 3 Started ***");

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
        softAssert.assertEquals(actLNameMsg,expLNameMsg);
        softAssert.assertEquals(actEmailMsg,expEmailMsg);
        softAssert.assertEquals(actPasswordMsg,expPasswordMsg);
        softAssert.assertEquals(actPasswordConfMsg,expPasswordConfMsg);
        softAssert.assertAll();
        log.info("***  Registration Test 3 finished ***");

    }

}
