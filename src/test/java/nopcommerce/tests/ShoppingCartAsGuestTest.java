package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;

public class ShoppingCartAsGuestTest extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartAsGuestTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","ShoppingCartAsGuestTest");

    String itemName = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","itemName");
    int defaultShoppingCartQuantityNumber = 0;
    int givenShoppingCartQuantityNumber = 2000;
    HomePage homePage;
    ProductPage productPage;
    SearchPage searchPage;
    ShoppingCartPage shoppingCartPage;


    //Verify shopping cart quantity of items is 0 by default
    @Test
    public void defaultShoppingCartQuantityTest() {
        log.info("***  Shopping cart Test defaultShoppingCartQuantityTest Started ***");
        homePage = new HomePage(getDriver());
        String quantity = homePage.getShoppingCartQuantity();
        int number = extractNumberBetweenBrackets(quantity);
        Assert.assertEquals(number, defaultShoppingCartQuantityNumber);
        log.info("default Shopping cart quantity number as expected");
        log.info("***  Shopping cart Test defaultShoppingCartQuantityTest Ended ***");
    }
    //Verify shopping cart quantity of items is updated when adding items
    @Test
    public void updateOfShoppingCartQuantityNumberTest() {
        log.info("***  Shopping cart Test updateOfWishlistQuantityNumberTest Started ***");
        homePage = new HomePage(getDriver());
        homePage.typeItemAndClickSearch(itemName);

        searchPage = new SearchPage(getDriver());
        searchPage.clickOnItemName();
        productPage = new ProductPage(getDriver());
        productPage.enterNumberOfItems(givenShoppingCartQuantityNumber);

        productPage.addToCart();
        productPage.clickOnCloseNotification();

        String quantity = homePage.getShoppingCartQuantity();
        int number = extractNumberBetweenBrackets(quantity);
        Assert.assertEquals(number,givenShoppingCartQuantityNumber);
        log.info("default Shopping cart quantity number as expected");
        log.info("***  Shopping cart Test updateOfWishlistQuantityNumberTest Ended ***");
    }

    //Add item to Shopping cart and confirm item name is present in Shopping cart
    @Test
    public void searchAndAddToShoppingCartTest(){
        log.info("***  Shopping cart Test searchAndAddToWishlistTest Started ***");

        homePage = new HomePage(getDriver());
        homePage.typeItemAndClickSearch(itemName);
        String actualTitle = getCurrentTitle();
        String expectedTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","search page");
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
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

        log.info("***  Shopping cart Test searchAndAddToWishlistTest Ended ***");
    }


}
