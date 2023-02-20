package saucedemotest;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemopages.InventoryPage;
import saucedemopages.LoginPage;

public class MenuBarTest extends CommonAPI {
    Logger LOG = LoggerFactory.getLogger(saucedemotest.MenuBarTest.class);


    @Test
    public void menuBarAllItemsTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.menuBarButton();
        LOG.info("Menu Bar click successful");
        inventory.allItemsSideBar();
        LOG.info("All Items Side Bar click successful");
        String expectedUrlLink = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrlLink, getCurrentURL());
        LOG.info("Redirected to https://saucedemo.com/inventory.html");
    }

    @Test
    public void menuBarAboutTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.menuBarButton();
        LOG.info("Menu Bar click successful");
        inventory.aboutSideBar();
        LOG.info("About Side Bar click successful");
        String expectedUrlLink = "https://saucelabs.com/";
        Assert.assertEquals(expectedUrlLink, getCurrentURL());
        LOG.info("Redirected to https://saucelabs.com/");
    }

    @Test
    public void menuBarLogoutTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.menuBarButton();
        LOG.info("Menu Bar click successful");
        inventory.logOutSideBar();
        LOG.info("Logout Side Bar click successful");
        String expectedUrlLink = "https://www.saucedemo.com/";
        Assert.assertEquals(expectedUrlLink, getCurrentURL());
        LOG.info("Redirected to https://saucedemo.com/");
    }


}






