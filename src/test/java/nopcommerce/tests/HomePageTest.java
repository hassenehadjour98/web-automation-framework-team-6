package nopcommerce.tests;

import base.CommonAPI;
import nopcommerce.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class HomePageTest extends CommonAPI {
    Logger log = LogManager.getLogger(HomePageTest.class.getName());

   @Test
    public void clkOnLnkRegisterTest () throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(3000);
        homePage.clkOnLnkRegister();
       String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,"nopCommerce demo store. Register");

    }
}
