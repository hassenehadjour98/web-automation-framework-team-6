package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.LogInPageNop;
import nopcommerce.pages.MyAccountPage;
import nopcommerce.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.GenerateData;
import utility.ReadFromExcel;

public class LogOutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogOutTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","LogOutTest");

    String msgRegistrationSuccess = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","msgRegistrationSuccess");
    String expectedMyAccountLinkText = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedMyAccountLinkText");
    String expectedLogInLinkText = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedLogInLinkText");
    String validEmail = GenerateData.email(), validPassword = GenerateData.password();
    RegistrationPage registrationPage;
    LogInPageNop logInPageNop;
    HomePage homePage;
    MyAccountPage myAccountPage;
    @Test
    public void createAccount () {
        homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
        String actualTitle = getCurrentTitle();
        String expRegisterPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","register page");
        Assert.assertEquals(actualTitle, expRegisterPageTitle, "Did not land on registration page");
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
        Assert.assertEquals(returnedMessage, msgRegistrationSuccess);
        log.info("Registration success message returned");
    }

//    Login and logout using link on top of the page
    @Test(dependsOnMethods = {"createAccount"})
    public void logInAndLogOutUsingLogOutLinkTest () {
        log.info("***  Log out Test logInAndLogOutUsingLogOutLinkTest started ***");
//        1.click login link
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
//      2.enter valid credentials and click login
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        myAccountPage = new MyAccountPage(getDriver());
        String actualMyAccountLinkText = myAccountPage.getMyAccountLinkText();
        Assert.assertEquals(actualMyAccountLinkText,expectedMyAccountLinkText);
        log.info("Logged in successfully");
//        3. log out
        myAccountPage.logOut();
        String actualLogInLinkText = homePage.getLogInLinkText();
        Assert.assertEquals(actualLogInLinkText,expectedLogInLinkText);
        log.info("Logged out successfully");
        String actTitle = getCurrentTitle();
        String expectedHomePageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title", "home page");
        Assert.assertEquals(actTitle,expectedHomePageTitle);
        log.info("landed on home page page success");

        log.info("***  Log out Test logInAndLogOutUsingLogOutLinkTest finished ***");
    }//    Login and logout using link on top of the page
    @Test(dependsOnMethods = {"createAccount"})
    public void logInAndLogOutNavigateBackForwardTest () {
        log.info("***  Log out Test logInAndLogOutNavigateBackForwardTest started ***");
//        1.click login link
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
//      2.enter valid credentials and click login
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        myAccountPage = new MyAccountPage(getDriver());
        String actualMyAccountLinkText = myAccountPage.getMyAccountLinkText();
        Assert.assertEquals(actualMyAccountLinkText,expectedMyAccountLinkText);
        log.info("Logged in successfully");
//        3. log out
        myAccountPage.logOut();
//        4. navigate back
        navigateBack();
//        5.navigate forward
        navigateForward();

        String actualLogInLinkText = homePage.getLogInLinkText();
        Assert.assertEquals(actualLogInLinkText,expectedLogInLinkText);
        log.info("Logged out successfully");
        String actTitle = getCurrentTitle();
        String expectedHomePageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title", "home page");
        Assert.assertEquals(actTitle,expectedHomePageTitle);
        log.info("landed on home page success");

        log.info("***  Log out Test logInAndLogOutNavigateBackForwardTest finished ***");
    }



}
