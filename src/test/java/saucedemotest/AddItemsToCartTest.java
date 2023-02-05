package saucedemotest;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemopages.InventoryPage;
import saucedemopages.LoginPage;

public class AddItemsToCartTest extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(AddItemsToCartTest.class);

    @Test
    public void addBackPackToCartTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addBackPack();
        LOG.info("Back pack added to cart");
        String expectedText = "REMOVE";
        Assert.assertEquals(expectedText, inventory.removeBackPack());
    }

    @Test
    public void addBikeLightToCartTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addBikeLight();
        LOG.info("Bike light added to cart");
        String expectedText = "REMOVE";
        Assert.assertEquals(expectedText, inventory.removeBikeLight());
    }

    @Test
    public void addBoltShirtToCartTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addBoltTshirt();
        LOG.info("Bolt T-Shirt added to cart");
        String expectedText = "REMOVE";
        Assert.assertEquals(expectedText, inventory.removeBoltShirt());
    }

    @Test
    public void addFleeceJacketToCartTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addFleeceJacket();
        LOG.info("Fleece Jacket added to cart");
        String expectedText = "REMOVE";
        Assert.assertEquals(expectedText, inventory.removeFleeceJacket());
    }

    @Test
    public void addRedShirtToCartTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addRedTshirt();
        LOG.info("Red T-Shirt added to cart");
        String expectedText = "REMOVE";
        Assert.assertEquals(expectedText, inventory.removeRedShirt());
    }

    @Test
    public void addMultipleItemsToCartTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("standard_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addRedTshirt();
        inventory.addBikeLight();
        inventory.addBoltTshirt();
        LOG.info("Red T-Shirt added to cart");
        LOG.info("Bike light added to cart");
        LOG.info("Bolt T-Shirt added to cart");
        String expectedText = "REMOVE";
        Assert.assertEquals(expectedText, inventory.removeRedShirt());
        Assert.assertEquals(expectedText, inventory.removeBikeLight());
        Assert.assertEquals(expectedText, inventory.removeBoltShirt());    }

}