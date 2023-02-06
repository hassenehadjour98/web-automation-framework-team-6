package nopcommerce.tests;

import base.CommonAPI;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.ProductPage;
import com.nopcommerce.pages.SearchPage;
import com.nopcommerce.pages.ShoppingCartPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends CommonAPI {
    Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());
    String itemName ="Lenovo IdeaCentre 600 All-in-One PC";
    int defaultShoppingCartQuantityNumber = 0;
    int updatedShoppingCartQuantityNumber =2000;
    HomePage homePage;
    ProductPage productPage;
    SearchPage searchPage;
    ShoppingCartPage shoppingCartPage;


    //Verify shopping cart quantity of items is 0 by default
    @Test
    public void defaultShoppingCartQuantityTest() {
        log.info("***  Shopping cart Test defaultShoppingCartQuantityTest Started ***");
        homePage = new HomePage(getDriver());
        String actualShoppingCartQuantity = homePage.getShoppingCartQuantity();
        String quantityNumber = actualShoppingCartQuantity.substring(actualShoppingCartQuantity.indexOf('(')+1,actualShoppingCartQuantity.indexOf(')'));
        int actualShoppingCartQuantityNumber = Integer.parseInt(quantityNumber);
        Assert.assertEquals(actualShoppingCartQuantityNumber, defaultShoppingCartQuantityNumber);
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
        productPage.enterNumberOfItems(updatedShoppingCartQuantityNumber);

        productPage.addToCart();
        productPage.clickOnCloseNotification();

        String actualShoppingCartQuantity = homePage.getShoppingCartQuantity();
        String quantityNumber = actualShoppingCartQuantity.substring(actualShoppingCartQuantity.indexOf('(')+1,actualShoppingCartQuantity.indexOf(')'));
        int actualShoppingCartQuantityNumber = Integer.parseInt(quantityNumber);
        Assert.assertEquals(actualShoppingCartQuantityNumber,updatedShoppingCartQuantityNumber);
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
        String expectedTitle = "nopCommerce demo store. Search";
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
