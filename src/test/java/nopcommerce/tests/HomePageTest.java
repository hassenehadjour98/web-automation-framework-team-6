package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;

public class HomePageTest extends CommonAPI {
    Logger log = LogManager.getLogger(HomePageTest.class.getName());
    ReadFromExcel readTitleFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","titles");
    ReadFromExcel readTestDataFromExcel = new ReadFromExcel(System.getProperty("user.dir")+"\\Data\\nopcommerce\\nopCommerceData.xlsx","HomePageTest");


    @Test
    public void clkOnLnkRegisterTest ()  {

        HomePage homePage = new HomePage(getDriver());
        homePage.clkOnLnkRegister();
       String actualTitle = getCurrentTitle();
       String expectedRegisterPageTitle = readTitleFromExcel.getCellValueForGivenHeaderAndKey("title","register page");
        Assert.assertEquals(actualTitle,expectedRegisterPageTitle);

    }
}
