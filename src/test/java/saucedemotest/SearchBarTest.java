package saucedemotest;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemopages.InventoryPage;
import saucedemopages.LoginPage;
import saucedemopages.SauceLabsPage;

public class SearchBarTest extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(saucedemotest.SearchBarTest.class);

    @Test
    public void searchDogsTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("performance_glitch_user");
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
        SauceLabsPage sauceLabs = new SauceLabsPage(getDriver());
        sauceLabs.clickSearchButton();
        LOG.info("Search button click successful");
        sauceLabs.typeAndEnterSearchBar("Dogs");
        LOG.info("'Dogs' input successfully into Search Bar");
        String expectedUrlLink2 = "https://saucelabs.com/search?q=Dogs";
        Assert.assertEquals(expectedUrlLink2, getCurrentURL());
        LOG.info("Redirected to https://saucelabs.com/search?q=Dogs");
    }


    @Test
    public void searchAndRedirectBackToHomeTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("performance_glitch_user");
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
        SauceLabsPage sauceLabs = new SauceLabsPage(getDriver());
        sauceLabs.clickSearchButton();
        LOG.info("Search button click successful");
        sauceLabs.typeAndEnterSearchBar("Sauce");
        LOG.info("'Sauce' input successfully into Search Bar");
        String expectedUrlLink2 = "https://saucelabs.com/search?q=Sauce";
        Assert.assertEquals(expectedUrlLink2, getCurrentURL());
        LOG.info("Redirected to https://saucelabs.com/search?q=Sauce");
        sauceLabs.clickSauceLink();
        LOG.info("Link click successful");
        String expectedUrlLink3 = "https://saucelabs.com/";
        Assert.assertEquals(expectedUrlLink3, getCurrentURL());
        LOG.info("Redirected to https://saucelabs.com/");
    }

}





