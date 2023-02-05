package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchTest.class.getName());
    String itemName ="Nokia Lumia 1020";


    @Test
    public void searchAndValidateItemNameAndPrice(){
        log.info("***  Search Test Started ***");

        HomePage homePage = new HomePage(getDriver());
        homePage.typeItemAndClickSearch(itemName);
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Search";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
        log.info("Landed on search page successfully");

        SearchPage searchPage = new SearchPage(getDriver());
        String actualItemName = searchPage.getItemName();
        Assert.assertEquals(actualItemName, itemName,"Item not found");
        log.info("Item found successfully");

        String actualPrice = searchPage.getItemPrice();
        String expectedPrice = "$349.00";
        Assert.assertEquals(actualPrice,expectedPrice,"Price not as expected");
        log.info("Item price as expected");

        log.info("***  Search Test Ended ***");
    }
}
