package nopcommerce.tests;

import base.CommonAPI;
import com.github.javafaker.Faker;
import com.nopcommerce.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(checkoutTest.class.getName());
    String expRegisterPageTitle = "nopCommerce demo store. Register";
    String msgRegistrationSuccess = "Your registration completed";
    String itemName ="Windows 8 Pro";
    Faker faker = new Faker();
    String firstName = faker.name().firstName() ,lastName = faker.name().lastName();
    String validEmail = faker.internet().emailAddress(), validPassword = faker.internet().password();
    RegistrationPage registrationPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    SearchPage searchPage;
    ShoppingCartPage shoppingCartPage;
    LogInPageNop logInPageNop;
    MyAccountPage myAccountPage;

    //Demo website requires to create an account before testing.
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
    @Test(dependsOnMethods = {"createAccount"})
    public void logInAddToCartAndClickOnCheckoutTest(){
        log.info("***  Checkout Test logInAddToCartAndClickOnCheckoutTest Started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        homePage.typeItemAndClickSearch(itemName);
        log.info("Landed on search page successfully");
        //Validate Item Name
        searchPage = new SearchPage(getDriver());
        String actualSearchItemName = searchPage.getItemName();
        Assert.assertEquals(actualSearchItemName, itemName,"Item not found");
        log.info("Item found successfully");
        //Add to cart
        searchPage.addToCart();
        //go to cart
        homePage.clkOnLinkShoppingCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        //get product name in cart
        String actualShoppingCartProductName = shoppingCartPage.getCartProductName();
        Assert.assertEquals(actualShoppingCartProductName,itemName);
        log.info("Item added to Shopping cart Successfully");
        shoppingCartPage.checkAgreeToTermsOfService();
        shoppingCartPage.clickOnCheckout();
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Checkout";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on Checkout page");
        log.info("Landed on Checkout page successfully");


        log.info("***  Checkout Test logInAddToCartAndClickOnCheckoutTest Ended ***");
    }

    //LogIn, search and add item to cart, log out, login again and go to cart, item should be saved
    @Test(dependsOnMethods = {"createAccount"})
    public void checkItemSavedInCartTest(){
        log.info("***  Checkout Test checkItemSavedInCartTest Started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        homePage.typeItemAndClickSearch(itemName);
        log.info("Landed on search page successfully");
        //Validate Item Name
        searchPage = new SearchPage(getDriver());
        String actualSearchItemName = searchPage.getItemName();
        Assert.assertEquals(actualSearchItemName, itemName,"Item not found");
        log.info("Item found successfully");
        //Add to cart
        searchPage.addToCart();
        //log out
        myAccountPage = new MyAccountPage(getDriver());
        myAccountPage.logOut();
        //login again
        homePage.clkOnLinkLogin();
        logInPageNop.logIn(validEmail,validPassword);

        //go to cart
        homePage.clkOnLinkShoppingCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        //get product name in cart
        String actualShoppingCartProductName = shoppingCartPage.getCartProductName();
        Assert.assertEquals(actualShoppingCartProductName,itemName);
        log.info("Item saved in Shopping cart Successfully");

        log.info("***  Checkout Test checkItemSavedInCartTest Ended ***");
    }
}
