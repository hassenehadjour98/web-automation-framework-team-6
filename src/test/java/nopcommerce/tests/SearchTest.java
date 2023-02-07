package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import nopcommerce.pages.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ConnectDB;
import utility.ReadFromExcel;

import java.util.List;

public class SearchTest extends CommonAPI {
    Logger log = LogManager.getLogger(SearchTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","SearchTest");
    String nonExistingItem = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","nonExistingItem");
    String expectedAlertText = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedAlertText");
    String expectedSearchResultMessage = readTestDataFromExcel.getCellValueForGivenHeaderAndKey("variable","expectedSearchResultMessage");
    SearchPage searchPage;
    HomePage homePage;
    @DataProvider (name = "searchItems")
    public Object[][] getSearchData(){
        List<String> items = ConnectDB.getTableColumnData("select * from search_items","item_name");
        List<String> prices = ConnectDB.getTableColumnData("select * from search_items","item_price");

        Object[][] data = {
                {items.get(0),prices.get(0)},
                {items.get(1),prices.get(1)},
                {items.get(2),prices.get(2)},
                {items.get(3),prices.get(3)},
                {items.get(4),prices.get(4)},
                {items.get(5),prices.get(5)},
        };
        return data;
    }

//    Validate searching with an existing Product Name
    @Test (dataProvider = "searchItems")
    public void searchAndValidateItemNameAndPrice(String itemName, String itemPrice){
        log.info("***  Search Test searchAndValidateItemNameAndPrice Started ***");

        homePage = new HomePage(getDriver());
//        1. Enter existing product name into the 'Search' text box field
//        2. Click on the button search icon
        homePage.typeItemAndClickSearch(itemName);
        String actualTitle = getCurrentTitle();
        String expectedTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","search page");
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
        log.info("Landed on search page successfully");
//       3.validate item name
        searchPage = new SearchPage(getDriver());
        String actualItemName = searchPage.getItemName();
        Assert.assertEquals(actualItemName, itemName,"Item not found");
        log.info("Item found successfully");
//        4.validate item price
        String actualPrice = searchPage.getItemPrice();
        Assert.assertEquals(actualPrice,itemPrice,"Price not as expected");
        log.info("Item price as expected");

        log.info("***  Search Test searchAndValidateItemNameAndPrice Ended ***");
    }

//    Validate searching without providing any Product Name

    @Test
    public void searchWithoutProvidingProductNameTest()  {
        log.info("***  Search Test searchWithoutProvidingProductNameTest Started ***");

        homePage = new HomePage(getDriver());
//        1.  Click on the button search icon without providing product name
        homePage.typeItemAndClickSearch("");
        String actualAlertText = getTextFromAlert();
        log.info("Text captured from alert success");
        Assert.assertEquals(actualAlertText,expectedAlertText);
        acceptAlert();
        String actualTitle = getCurrentTitle();
        String expectedHomePageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title", "home page");
        Assert.assertEquals(actualTitle,expectedHomePageTitle);
        log.info("Stayed on home page successfully");

        log.info("***  Search Test searchWithoutProvidingProductNameTest Ended ***");
    }
//    Validate searching a non-existing Product Name
    @Test
    public void searchNonExistingProductNameTest () {
        log.info("***  Search Test searchNonExistingProductNameTest Started ***");

        homePage = new HomePage(getDriver());
//        1. Enter a non-existing product name into the 'Search' text box field
//        2. Click on the button search icon
        homePage.typeItemAndClickSearch(nonExistingItem);
        String actualTitle = getCurrentTitle();
        String expectedTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","search page");;
        Assert.assertEquals(actualTitle, expectedTitle,"Did not land on search page");
        log.info("Landed on search page successfully");
        searchPage = new SearchPage(getDriver());
        String actualSearchResultMessage = searchPage.getTextNoResultSearch();
        Assert.assertEquals(actualSearchResultMessage, expectedSearchResultMessage);
        log.info("no product found message displayed successfully");

        log.info("***  Search Test searchNonExistingProductNameTest Ended ***");
    }


}
