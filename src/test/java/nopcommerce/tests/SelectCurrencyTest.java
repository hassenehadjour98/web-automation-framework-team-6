package nopcommerce.tests;

import base.CommonAPI;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectCurrencyTest extends CommonAPI {
    Logger log = LogManager.getLogger(SelectCurrencyTest.class.getName());
    String defaultCurrency = "US Dollar";
    String currency2 = "Euro";
    String itemName ="Nokia Lumia 1020";
    HomePage homePage;
    SearchPage searchPage;


    //Verify Currency Displayed By Default is US Dollar
    @Test
    public void verifyDefaultDisplayedCurrency() {
        log.info("***  Select currency Test verifyDefaultDisplayedCurrency Started ***");

        homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.usDollarIsSelected());
        Assert.assertFalse(homePage.euroIsSelected());
        log.info("Default Currency Displayed successfully");

        log.info("***  Select currency Test verifyDefaultDisplayedCurrency finished ***");
    }
    //Switch to New Currency and verify currency name is displayed
    @Test
    public void verifySelectedCurrencyIsDisplayed() {
        log.info("***  Select currency Test verifySelectedCurrencyIsDisplayed Started ***");

        homePage = new HomePage(getDriver());

        homePage.selectCurrency(currency2);
        Assert.assertTrue(homePage.euroIsSelected());
        Assert.assertFalse(homePage.usDollarIsSelected());
        log.info("New selected currency displayed successfully");

        log.info("***  Select currency Test verifySelectedCurrencyIsDisplayed finished ***");
    }
    //Select different Currency Then Search And Validate Item Name and Price
    @Test
    public void selectCurrencyThenSearchAndValidateItemPrice() {
        log.info("***  Select currency Test selectCurrencyThenSearchAndValidateItemPrice Started ***");
        //Switch Currency
        homePage = new HomePage(getDriver());
        homePage.selectCurrency(currency2);
        homePage.typeItemAndClickSearch(itemName);
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Search";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
        log.info("Landed on search page successfully");

        //Validate Found Item Name
        searchPage = new SearchPage(getDriver());
        String actualItemName = searchPage.getItemName();
        Assert.assertEquals(actualItemName, itemName,"Item not found");
        log.info("Item found successfully");

        //Validate Item Price Is Displayed In New Currency
        String actualPrice = searchPage.getItemPrice();
        String expectedPrice = "€300.14";
        Assert.assertEquals(actualPrice,expectedPrice,"Price not as expected");
        log.info("Item price as expected");

        log.info("***  Select currency Test selectCurrencyThenSearchAndValidateItemPrice finished ***");
    }

    //Search Item Then Switch Currency and validate price is converted
    @Test
    public void confirmItemPriceConversion() {
        log.info("***  Select currency Test confirmItemPriceConversion Started ***");

        homePage = new HomePage(getDriver());

        homePage.typeItemAndClickSearch(itemName);
        String actualTitle = getCurrentTitle();
        String expectedTitle = "nopCommerce demo store. Search";
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
        log.info("Landed on search page successfully");

        searchPage = new SearchPage(getDriver());
        String actualItemName = searchPage.getItemName();
        Assert.assertEquals(actualItemName, itemName,"Item not found");
        log.info("Item found successfully");

        String actualPrice = searchPage.getItemPrice();
        String expectedPrice = "$349.00";
        Assert.assertEquals(actualPrice,expectedPrice,"Price not as expected");
        log.info("Item price as expected");

        homePage.selectCurrency(currency2);
        Assert.assertTrue(homePage.euroIsSelected());
        log.info("New currency selected successfully");

        String actConvertedPrice = searchPage.getItemPrice();
        String expConvertedPrice = "€300.14";
        Assert.assertEquals(actConvertedPrice,expConvertedPrice,"Price not as expected");
        log.info("Item price converted successfully");


        log.info("***  Select currency Test confirmItemPriceConversion finished ***");
    }
}
