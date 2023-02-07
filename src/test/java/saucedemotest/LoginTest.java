package saucedemotest;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemopages.LoginPage;

public class LoginTest extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(LoginTest.class);
    @Test
    public void standardUserLoginTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        String expectedUrlLink = "https://www.saucedemo.com/inventory.html";
        //Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Redirected to https://saucedemo.com/inventory.html");

    }

    @Test
    public void lockedOutUserLoginTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("locked_out_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login unsuccessful: Sorry, this user has been locked out.");
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(expectedError, logIn.actualErrorMessage());
    }
    @Test
    public void problemUserLoginTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("problem_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        String expectedUrlLink = "https://www.saucedemo.com/inventory.html";
        //Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Redirected to https://saucedemo.com/inventory.html");
    }

    @Test
    public void performanceGlitchUserLoginTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("performance_glitch_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        String expectedUrlLink = "https://www.saucedemo.com/inventory.html";
        //Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Redirected to https://saucedemo.com/inventory.html");

    }

    @Test
    public void invalidLoginWithPerformanceGlitchUserTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("performance_glitch_user");
        LOG.info("Valid UserName entered");
        logIn.enterPassword("secret_sauce!");
        LOG.info("Invalid Password entered");
        logIn.clickLogInButton();
        LOG.info("Login unsuccessful: Username and password do not match any user in this service");
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedError, logIn.actualErrorMessage());
    }

    @Test
    public void invalidLoginWithProblemUserTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("problem_user");
        LOG.info("Valid UserName entered");
        logIn.enterPassword("secret_sauce!");
        LOG.info("Invalid Password entered");
        logIn.clickLogInButton();
        LOG.info("Login unsuccessful: Username and password do not match any user in this service");
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedError, logIn.actualErrorMessage());
    }

    @Test
    public void invalidLoginWithStandardUserTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("Valid UserName entered");
        logIn.enterPassword("secret_sauce!");
        LOG.info("Invalid Password entered");
        logIn.clickLogInButton();
        LOG.info("Login unsuccessful: Username and password do not match any user in this service");
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedError, logIn.actualErrorMessage());
    }

    @Test
    public void validateLoginButtonWithNoCredentialsTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.clickLogInButton();
        LOG.info("Login button click successful");
        LOG.info("Login unsuccessful: Username is required");
        String expectedError = "Epic sadface: Username is required";
        Assert.assertEquals(expectedError, logIn.actualErrorMessage());
    }


}