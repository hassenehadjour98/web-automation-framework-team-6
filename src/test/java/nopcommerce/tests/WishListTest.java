package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.ProductPage;
import nopcommerce.pages.SearchPage;
import nopcommerce.pages.WishlistPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends CommonAPI {
    Logger log = LogManager.getLogger(WishListTest.class.getName());
    String itemName ="HP Spectre XT Pro UltraBook";
    HomePage homePage;
    SearchPage searchPage;
    WishlistPage wishlistPage;
    ProductPage productPage;
    int defaultWishlistQuantityNumber = 0;
    int updatedWishlistQuantityNumber =1000;


    //Verify wishlist quantity of items is 0 by default
    @Test
    public void defaultWishlistQuantityTest() {
        log.info("***  WishList Test defaultWishlistQuantityTest Started ***");
        homePage = new HomePage(getDriver());
        String actualWishlistQuantity = homePage.getWishlistQuantity();
        String quantityNumber = actualWishlistQuantity.substring(actualWishlistQuantity.indexOf('(')+1,actualWishlistQuantity.indexOf(')'));
        int actualWishlistQuantityNumber = Integer.parseInt(quantityNumber);
        Assert.assertEquals(actualWishlistQuantityNumber,defaultWishlistQuantityNumber);
        log.info("default wishlist quantity number as expected");
        log.info("***  Wishlist Test defaultWishlistQuantityTest Ended ***");
    }
    //Verify wishlist quantity of items is updated when adding items
    @Test
    public void updateOfWishlistQuantityNumberTest() {
        log.info("***  WishList Test updateOfWishlistQuantityNumberTest Started ***");
        homePage = new HomePage(getDriver());
        homePage.typeItemAndClickSearch(itemName);

        searchPage = new SearchPage(getDriver());
        searchPage.clickOnItemName();
        productPage = new ProductPage(getDriver());
        productPage.enterNumberOfItems(updatedWishlistQuantityNumber);
        productPage.addToWishlist();
        productPage.clickOnCloseNotification();

        String actualWishlistQuantity = homePage.getWishlistQuantity();
        String quantityNumber = actualWishlistQuantity.substring(actualWishlistQuantity.indexOf('(')+1,actualWishlistQuantity.indexOf(')'));
        int actualWishlistQuantityNumber = Integer.parseInt(quantityNumber);
        Assert.assertEquals(actualWishlistQuantityNumber,updatedWishlistQuantityNumber);
        log.info("default wishlist quantity number as expected");
        log.info("***  Wishlist Test updateOfWishlistQuantityNumberTest Ended ***");
    }

    //Add item to wishlist and confirm item name is present in wishlist
    @Test
    public void searchAndAddToWishlistTest(){
        log.info("***  Wishlist Test searchAndAddToWishlistTest Started ***");

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
        //Add to Wishlist
        searchPage.addToWishlist();
        //go to wishlist
        homePage.clkOnLnkWishlist();
        wishlistPage = new WishlistPage(getDriver());
        String actualWishlistProductName = wishlistPage.getWishlistProductName();
        Assert.assertEquals(actualWishlistProductName,itemName);
        log.info("Item added to wishlist Successfully");

        log.info("***  Wishlist Test searchAndAddToWishlistTest Ended ***");
    }

}
