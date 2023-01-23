package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    @Test
    public void registrationTest1 () {
        log.info("***  Registration Test 1 Started ***");
        HomePage homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

        RegistrationPage rp = new RegistrationPage(getDriver());
        rp.clkOnMale();
        String firstName = "Tom" ,lastName = "Cruise", dayOfBirth = "3", monthOfBirth = "July", yearOfBirth = "1962";
        String email = "tomcruise1@gmail.com", companyName = "C/W Productions", password="07031962";


        rp.setFirstName(firstName);
        rp.setLastName(lastName);
        rp.selectDayOfBirth(dayOfBirth);
        rp.selectMonthOfBirth(monthOfBirth);
        rp.selectYearOfBirth(yearOfBirth);
        rp.setEmail(email);
        rp.setCompanyName(companyName);
        rp.selectNewsletter();
        rp.setPassword(password);
        rp.setConfirmPassword(password);
        rp.clkOnRegister();
        String msgRegistrationSuccess ="Your registration completed";
        String msgEmailExists ="The specified email already exists";

        String returnedMessage = rp.readReturnedMessage();
        if (returnedMessage.equals(msgRegistrationSuccess)){
            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");
        }

        else if (returnedMessage.equals(msgEmailExists)){
            String returnedEmail = rp.registeredEmail();
            Assert.assertEquals(returnedEmail,email);
            log.info("Email exists message returned");
            log.info("Email matches registered user");
        }
        log.info("***  Registration Test 1 finished ***");

    }
    @Test
    public void registrationTest2 () {
        log.info("***  Registration Test 2 Started ***");
        HomePage homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

        RegistrationPage rp = new RegistrationPage(getDriver());
        String firstName = "Tom" ,lastName = "Cruise", email = "tomcruise2@gmail.com", password="07031962";


        rp.setFirstName(firstName);
        rp.setLastName(lastName);
        rp.setEmail(email);
        rp.setPassword(password);
        rp.setConfirmPassword(password);
        rp.clkOnRegister();
        String msgRegistrationSuccess ="Your registration completed";
        String msgEmailExists ="The specified email already exists";

        String returnedMessage = rp.readReturnedMessage();
        if (returnedMessage.equals(msgRegistrationSuccess)){
            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");
        }

        else if (returnedMessage.equals(msgEmailExists)){
            String returnedEmail = rp.registeredEmail();
            Assert.assertEquals(returnedEmail,email);
            log.info("Email exists message returned");
            log.info("Email matches registered user");
        }
        log.info("***  Registration Test 2 finished ***");

    }
    @Test
    public void registrationTest3 () {
        log.info("***  Registration Test 3 Started ***");
        HomePage homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Register";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

        RegistrationPage rp = new RegistrationPage(getDriver());

        rp.clkOnRegister();

        String actFNameMsg = rp.getFNameReqMsg();
        String actLNameMsg = rp.getLNameReqMsg();
        String actEmailMsg = rp.getEmailReqMsg();
        String actPasswordMsg = rp.getPasswordReqMsg();
        String actPasswordConfMsg = rp.getPasswordConfReqMsg();

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
