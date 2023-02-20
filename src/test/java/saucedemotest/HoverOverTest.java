package saucedemotest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemopages.InventoryPage;
import saucedemopages.LoginPage;
import saucedemopages.SauceLabsPage;

import java.time.Duration;
    public class HoverOverTest extends CommonAPI {

        private final Logger LOG = LoggerFactory.getLogger(saucedemotest.HoverOverTest.class);


        @Test(priority = 1)
        public void hoverOverSolutionsTest() {
            LoginPage logIn = new LoginPage(getDriver());
            SauceLabsPage sauceLabs = new SauceLabsPage(getDriver());
            logIn.enterUserName("performance_glitch_user");
            LOG.info("UserName entered");
            logIn.enterPassword("secret_sauce");
            LOG.info("Password entered");
            logIn.clickLogInButton();
            LOG.info("Login successful");
            InventoryPage inventory = new InventoryPage(getDriver());
            inventory.menuBarButton();
            LOG.info("Menu Bar click successful");
            inventory.aboutSideBar();
            LOG.info("About Side Bar click successful");
            String expectedUrlLink = "https://saucelabs.com/";
            Assert.assertEquals(expectedUrlLink, getCurrentURL());
            LOG.info("Redirected to https://saucelabs.com/");
            WebElement solutions = getDriver().findElement(By.xpath("//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[1]/div[1]/div[1]/a[1]"));
            Actions actions = new Actions(getDriver());
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfAllElements(solutions));
            actions.click(solutions).build().perform();
            LOG.info("Visibility of Solutions dropdown options is present");
        }

        @Test(priority = 2)
        public void hoverOverPlatformTest() {
            LoginPage logIn = new LoginPage(getDriver());
            logIn.enterUserName("performance_glitch_user");
            LOG.info("UserName entered");
            logIn.enterPassword("secret_sauce");
            LOG.info("Password entered");
            logIn.clickLogInButton();
            LOG.info("Login successful");
            InventoryPage inventory = new InventoryPage(getDriver());
            inventory.menuBarButton();
            LOG.info("Menu Bar click successful");
            inventory.aboutSideBar();
            LOG.info("About Side Bar click successful");
            String expectedUrlLink = "https://saucelabs.com/";
            Assert.assertEquals(expectedUrlLink, getCurrentURL());
            LOG.info("Redirected to https://saucelabs.com/");
            WebElement platform = getDriver().findElement(By.xpath("//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[2]/div[1]/div[1]/a[1]"));
            Actions actions = new Actions(getDriver());
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfAllElements(platform));
            actions.click(platform).build().perform();
            LOG.info("Visibility of Platform dropdown options is present");
        }

        @Test(priority = 3)
        public void hoverOverPricingTest() {
            LoginPage logIn = new LoginPage(getDriver());
            logIn.enterUserName("performance_glitch_user");
            LOG.info("UserName entered");
            logIn.enterPassword("secret_sauce");
            LOG.info("Password entered");
            logIn.clickLogInButton();
            LOG.info("Login successful");
            InventoryPage inventory = new InventoryPage(getDriver());
            inventory.menuBarButton();
            LOG.info("Menu Bar click successful");
            inventory.aboutSideBar();
            LOG.info("About Side Bar successful");
            String expectedUrlLink = "https://saucelabs.com/";
            Assert.assertEquals(expectedUrlLink, getCurrentURL());
            LOG.info("Redirected to https://saucelabs.com/");
            WebElement pricing = getDriver().findElement(By.xpath("//body[1]/header[1]/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[3]/div[1]/div[1]/a[1]/span[1]"));
            Actions actions = new Actions(getDriver());
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfAllElements(pricing));
            actions.click(pricing).build().perform();
            LOG.info("Visibility of Pricing dropdown options is present");
        }

        @Test(priority = 4)
        public void hoverOverResourcesTest() {
            LoginPage logIn = new LoginPage(getDriver());
            logIn.enterUserName("performance_glitch_user");
            LOG.info("UserName entered");
            logIn.enterPassword("secret_sauce");
            logIn.clickLogInButton();
            LOG.info("Login successful");
            InventoryPage inventory = new InventoryPage(getDriver());
            inventory.menuBarButton();
            LOG.info("Menu Bar click successful");
            inventory.aboutSideBar();
            LOG.info("About Side Bar successful");
            String expectedUrlLink = "https://saucelabs.com/";
            Assert.assertEquals(expectedUrlLink, getCurrentURL());
            LOG.info("Redirected to https://saucelabs.com/");
            WebElement resources = getDriver().findElement(By.xpath("//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[4]/div[1]/div[1]/a[1]"));
            Actions actions = new Actions(getDriver());
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfAllElements(resources));
            actions.click(resources).build().perform();
            LOG.info("Visibility of Resources dropdown options is present");


        }

        @Test(priority = 5)
        public void hoverOverCompanyTest() {
            LoginPage logIn = new LoginPage(getDriver());
            logIn.enterUserName("performance_glitch_user");
            LOG.info("UserName entered");
            logIn.enterPassword("secret_sauce");
            LOG.info("Password entered");
            logIn.clickLogInButton();
            LOG.info("Login successful");
            InventoryPage inventory = new InventoryPage(getDriver());
            inventory.menuBarButton();
            LOG.info("Menu Bar click successful");
            inventory.aboutSideBar();
            LOG.info("About Side Bar successful");
            String expectedUrlLink = "https://saucelabs.com/";
            Assert.assertEquals(expectedUrlLink, getCurrentURL());
            LOG.info("Redirected to https://saucelabs.com/");
            WebElement pricing = getDriver().findElement(By.xpath("//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[5]/div[1]/div[1]/a[1]"));
            Actions actions = new Actions(getDriver());
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfAllElements(pricing));
            actions.click(pricing).build().perform();
            LOG.info("Visibility of Pricing dropdown options is present");

        }


    }


