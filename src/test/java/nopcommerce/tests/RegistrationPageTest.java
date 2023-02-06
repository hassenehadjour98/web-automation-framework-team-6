package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.GenerateData;
import utility.ReadFromExcel;

public class RegistrationPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegistrationPageTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","RegistrationPageTest");
    String monthOfBirth = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","monthOfBirth");
    String companyName = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","companyName");
    String msgRegistrationSuccess = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","msgRegistrationSuccess");
    String dayOfBirth = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","dayOfBirth");
    String yearOfBirth = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","yearOfBirth");
    String expectedRegisterPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","register page");
    String email = GenerateData.email(), password=GenerateData.password();
    HomePage homePage;
    RegistrationPage registrationPage;

//    Validate Registering an Account by providing all the fields
    @Test
    public void registerProvidingAllFieldsTest () {
        log.info("***  Registration Test registerProvidingAllFieldsTest Started ***");
        homePage = new HomePage(getDriver());
//        1. Click on 'Register'
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");
//        2. Enter new Account Details into all the Fields
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clkOnMale();
        registrationPage.setFirstName(GenerateData.firstName());
        registrationPage.setLastName(GenerateData.lastName());
        registrationPage.selectDayOfBirth(dayOfBirth);
        registrationPage.selectMonthOfBirth(monthOfBirth);
        registrationPage.selectYearOfBirth(yearOfBirth);
        registrationPage.setEmail(email);
        registrationPage.setCompanyName(companyName);
        registrationPage.selectNewsletter();
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
//        3. Click on 'Register'
        registrationPage.clkOnRegister();
//      4.Verify Registration success message is displayed
        String returnedMessage = registrationPage.readReturnedMessage();
            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");
        log.info("***  Registration Test registerProvidingAllFieldsTest finished ***");

    }
//    Validate Registering an Account by providing the existing account details (i.e. existing email address)
    @Test
    public void registerWithRegisteredEmailTest () {
        log.info("***  Registration Test registerWithRegisteredEmailTest Started ***");
//    1. Click on 'Register'
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");
//      2. Enter all fields with an existing email address
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clkOnMale();
        registrationPage.setFirstName(GenerateData.firstName());
        registrationPage.setLastName(GenerateData.lastName());
        registrationPage.selectDayOfBirth(dayOfBirth);
        registrationPage.selectMonthOfBirth(monthOfBirth);
        registrationPage.selectYearOfBirth(yearOfBirth);
        registrationPage.setEmail(email);
        registrationPage.setCompanyName(companyName);
        registrationPage.selectNewsletter();
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
//      3. Click on 'Register' button
        registrationPage.clkOnRegister();
//      4. Validate proper notification messages "The specified email already exists"  is displayed
        String returnedMessage = registrationPage.readReturnedMessage();
        String msgEmailExists =readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","msgEmailExists");
        Assert.assertEquals(returnedMessage,msgEmailExists);
        log.info("Email exists message returned");
            String returnedEmail = registrationPage.registeredEmail();
            Assert.assertEquals(returnedEmail,email);
            log.info("Email matches registered user");

        log.info("***  Registration Test registerWithRegisteredEmailTest finished ***");

    }
//    Validate Registering an Account by providing only the Mandatory fields
    @Test
    public void registerProvidingOnlyMandatoryFields () {
        log.info("***  Registration Test registerProvidingOnlyMandatoryFields Started ***");
//        1. Click on 'Register'
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

//        2. Enter new Account Details into the Mandatory Fields
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.setFirstName(GenerateData.firstName());
        registrationPage.setLastName(GenerateData.lastName());
        registrationPage.setEmail(GenerateData.email());
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
//        3. Click on 'Register' button
        registrationPage.clkOnRegister();
//        4.Verify Registration success message is displayed

        String returnedMessage = registrationPage.readReturnedMessage();
            Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
            log.info("Registration success message returned");

        log.info("***  Registration Test registerProvidingOnlyMandatoryFields finished ***");

    }
//    Validate proper notification messages are displayed for the mandatory fields,
//    when you don't provide any fields in the 'Register Account' page and submit
    @Test
    public void registerWithoutProvidingAnyData () {
        log.info("***  Registration Test registerWithoutProvidingAnyData Started ***");
//        1. Click on 'Register'
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");
//        2. Don't enter anything into the fields
//        3. Click on 'Continue' button
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clkOnRegister();
//       4. Validate proper notification messages are displayed for the mandatory fields
        String actFNameMsg = registrationPage.getFNameReqMsg();
        String actLNameMsg = registrationPage.getLNameReqMsg();
        String actEmailMsg = registrationPage.getEmailReqMsg();
        String actPasswordMsg = registrationPage.getPasswordReqMsg();
        String actPasswordConfMsg = registrationPage.getPasswordConfReqMsg();

        SoftAssert softAssert = new SoftAssert();

        String expFNameMsg = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expFNameMsg");
        softAssert.assertEquals(actFNameMsg,expFNameMsg);
        log.info("First name is required. msg displayed success");
        String expLNameMsg = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expLNameMsg");
        softAssert.assertEquals(actLNameMsg,expLNameMsg);
        log.info("Last name is required. msg displayed success");
        String expEmailMsg = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expEmailMsg");
        softAssert.assertEquals(actEmailMsg,expEmailMsg);
        log.info("Email is required. msg displayed success");
        String expPasswordMsg = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expPasswordMsg");
        softAssert.assertEquals(actPasswordMsg,expPasswordMsg);
        log.info("Password is required. msg displayed success");
        String expPasswordConfMsg = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expPasswordConfMsg");
        softAssert.assertEquals(actPasswordConfMsg,expPasswordConfMsg);
        log.info("Password is required. msg displayed success");
        softAssert.assertAll();
        log.info("***  Registration Test registerWithoutProvidingAnyData finished ***");

    }
    //    Validate Registering an Account by providing all the fields without providing confirm password field
    @Test
    public void registerWithoutProvidingConfirmPasswordFieldTest () {
        log.info("***  Registration Test registerWithoutProvidingConfirmPasswordFieldTest Started ***");
        homePage = new HomePage(getDriver());
//        1. Click on 'Register'
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");
//        2. Enter new Account Details into all the Fields
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clkOnMale();
        registrationPage.setFirstName(GenerateData.firstName());
        registrationPage.setLastName(GenerateData.lastName());
        registrationPage.selectDayOfBirth(dayOfBirth);
        registrationPage.selectMonthOfBirth(monthOfBirth);
        registrationPage.selectYearOfBirth(yearOfBirth);
        registrationPage.setEmail(GenerateData.email());
        registrationPage.setCompanyName(companyName);
        registrationPage.selectNewsletter();
//        3. Only provide password field
        registrationPage.setPassword(password);
//        3. Click on 'Register'
        registrationPage.clkOnRegister();
//      4.Verify "Password is required" message is displayed
        String actPasswordConfMsg = registrationPage.getPasswordConfReqMsg();
        String expPasswordConfMsg = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expPasswordConfMsg");
        Assert.assertEquals(actPasswordConfMsg,expPasswordConfMsg);
        log.info("Password is required. msg displayed success");
        log.info("***  Registration Test registerWithoutProvidingConfirmPasswordFieldTest finished ***");

    }

    @DataProvider (name = "registerNewUsers")
    public Object [][] newUserData(){

        Object [][] data = {{GenerateData.firstName(), GenerateData.lastName(), GenerateData.email(),GenerateData.password()},
                {GenerateData.firstName(), GenerateData.lastName(), GenerateData.email(),GenerateData.password()},
                {GenerateData.firstName(), GenerateData.lastName(), GenerateData.email(),GenerateData.password()},
                {GenerateData.firstName(), GenerateData.lastName(), GenerateData.email(),GenerateData.password()},
                {GenerateData.firstName(), GenerateData.lastName(), GenerateData.email(),GenerateData.password()},
                };
        return data;
    }


    //    Validate Registering Multiple Accounts by providing only the Mandatory fields
    @Test (dataProvider = "registerNewUsers")
    public void registerMultipleUsersWithMandatoryFieldsTest (String firstName, String lastName, String email, String password) {
        log.info("***  Registration Test registerMultipleUsersWithMandatoryFieldsTest Started ***");
//        1. Click on 'Register'
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle,"Did not land on registration page");
        log.info("Landed on registration page successfully");

//        2. Enter new Account Details into the Mandatory Fields
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
//        3. Click on 'Register' button
        registrationPage.clkOnRegister();
//        4.Verify Registration success message is displayed

        String returnedMessage = registrationPage.readReturnedMessage();
        Assert.assertEquals(returnedMessage,msgRegistrationSuccess);
        log.info("Registration success message returned");

        log.info("***  Registration Test registerMultipleUsersWithMandatoryFieldsTest finished ***");

    }

}
