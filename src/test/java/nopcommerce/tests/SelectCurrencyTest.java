package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectCurrencyTest extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
    String mainCurrency = "US Dollar";
    String currency2 = "Euro";
    String item1 ="Nokia Lumia 1020";

    @Test
    public void selectCurrencyTest1() {
        log.info("***  Select currency Test 1 Started ***");

        HomePage hp = new HomePage(getDriver());
        hp.selectCurrency(currency2);
        hp.searchItem(item1);
        hp.clkSearchBtn();
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Search";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
        log.info("Landed on search page successfully");

        SearchPage sp = new SearchPage(getDriver());
        String actualItemName = sp.getItemName();
        Assert.assertEquals(actualItemName, item1,"Item not found");
        log.info("Item found successfully");

        String actualPrice = sp.getItemPrice();
        String expectedPrice = "€300.14";
        Assert.assertEquals(actualPrice,expectedPrice,"Price not as expected");
        log.info("Item price as expected");

        log.info("***  Select currency Test 1 finished ***");
    }
    @Test
    public void selectCurrencyTest2() {
        log.info("***  Select currency Test 2 Started ***");

        HomePage hp = new HomePage(getDriver());

        Assert.assertTrue(hp.usDollarIsSelected());
        Assert.assertFalse(hp.euroIsSelected());

        hp.selectCurrency(currency2);
        Assert.assertTrue(hp.euroIsSelected());
        Assert.assertFalse(hp.usDollarIsSelected());
        log.info("New currency selected successfully");

        log.info("***  Select currency Test 2 finished ***");
    }
    @Test
    public void selectCurrencyTest3() {
        log.info("***  Select currency Test 3 Started ***");

        HomePage hp = new HomePage(getDriver());

        hp.searchItem(item1);
        hp.clkSearchBtn();
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Search";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
        log.info("Landed on search page successfully");

        SearchPage sp = new SearchPage(getDriver());
        String actualItemName = sp.getItemName();
        Assert.assertEquals(actualItemName, item1,"Item not found");
        log.info("Item found successfully");

        String actualPrice = sp.getItemPrice();
        String expectedPrice = "$349.00";
        Assert.assertEquals(actualPrice,expectedPrice,"Price not as expected");
        log.info("Item price as expected");

        hp.selectCurrency(currency2);
        Assert.assertTrue(hp.euroIsSelected());
        log.info("New currency selected successfully");

        String actConvertedPrice = sp.getItemPrice();
        String expConvertedPrice = "€300.14";
        Assert.assertEquals(actConvertedPrice,expConvertedPrice,"Price not as expected");
        log.info("Item price converted successfully");


        log.info("***  Select currency Test 3 finished ***");
    }
}
