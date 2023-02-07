package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.GenerateData;
import utility.ReadFromExcel;

public class ShoppingCartAsUserTest extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartAsUserTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","ShoppingCartAsUserTest");

    String msgRegistrationSuccess = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","msgRegistrationSuccess");
    String expectedShoppingCartMsg = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedShoppingCartMsg");
    String itemName =readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","itemName");
    String firstName = GenerateData.firstName(),lastName = GenerateData.lastName();
    String validEmail = GenerateData.email(), validPassword = GenerateData.password();
    RegistrationPage registrationPage;
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
        String expectedRegisterPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","register page");
        Assert.assertEquals(actualTitle, expectedRegisterPageTitle, "Did not land on registration page");
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

    //LogIn, search and add item to cart, log out, login again and go to cart, item should be saved
    @Test(priority = 0, dependsOnMethods = {"createAccount"})
    public void checkItemSavedInCartTest(){
        log.info("***  LogIn Test checkItemSavedInCartTest Started ***");
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

        log.info("***  LogIn Test checkItemSavedInCartTest Ended ***");
    }

    //LogIn, go to cart, confirm product name in cart, delete the item already saved in cart
    @Test(priority = 1, dependsOnMethods = {"createAccount"})
    public void deleteItemSavedInCartTest(){
        log.info("***  LogIn Test deleteItemSavedInCartTest Started ***");
        homePage = new HomePage(getDriver());
        homePage.clkOnLinkLogin();
        log.info("Landed on login page success");
        logInPageNop = new LogInPageNop(getDriver());
        logInPageNop.logIn(validEmail,validPassword);

        //go to cart
        homePage.clkOnLinkShoppingCart();
        shoppingCartPage = new ShoppingCartPage(getDriver());
        //get product name in cart
        String actualShoppingCartProductName = shoppingCartPage.getCartProductName();
        Assert.assertEquals(actualShoppingCartProductName,itemName);
        log.info("Item saved in Shopping cart Successfully");

        //remove product
        shoppingCartPage.clickOnRemoveProduct();
        String actualShoppingCartMsg = shoppingCartPage.getTextEmptyShoppingCart();
        Assert.assertEquals(actualShoppingCartMsg,expectedShoppingCartMsg);
        log.info("Shopping cart cleared successfully");

        log.info("***  LogIn Test deleteItemSavedInCartTest Ended ***");
    }
}
