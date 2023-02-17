package saucedemotest;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import saucedemopages.InventoryPage;
import saucedemopages.LoginPage;

public class IconsTest extends CommonAPI {

    Logger LOG = LoggerFactory.getLogger(saucedemotest.IconsTest.class);

    @Test
    public void twitterIconTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("performance_glitch_user");
        LOG.info("User name entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.clickTwitterIcon();
        LOG.info("Twitter icon clicked successfully");
        LOG.info("Redirected to https://twiter.com/saucelabs");

    }

    @Test
    public void facebookIconTest(){
        LoginPage login = new LoginPage(getDriver());
        login.enterUserName("performance_glitch_user");
        LOG.info("User name entered");
        login.enterPassword("secret_sauce");
        LOG.info("Password entered");
        login.clickLogInButton();
        LOG.info("Login button clicked successfully");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.clickFacebookIcon();
        LOG.info("Facebook icon clicked successfully");
        LOG.info("Redirected to https://facebook.com/saucelabs");

    }

//    @Test
//
//    public void linkedInIconTest()  {
//        LoginPage login = new LoginPage(getDriver());
//        login.enterUserName("performance_glitch");
//        LOG.info("User name entered");
//        login.enterPassword("secret_sauce");
//        LOG.info("Password entered");
//        login.clickLogInButton();
//        LOG.info("Login button clicked successfully");
//        InventoryPage inventory = new InventoryPage(getDriver());
//        inventory.clickLinkedInIcon();
////        WebElement platform = getDriver().findElement(By.xpath("//a[contains(text(),'LinkedIn')]"));
////        Actions actions = new Actions(getDriver());
////        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
////        wait.until(ExpectedConditions.visibilityOfAllElements(platform));
////        actions.click(platform).build().perform();
////        Thread.sleep(3000);
//        LOG.info("LinkedIn icon clicked successfully");
//        LOG.info("Redirected to https://www.linkedin.com/company/sauce-labs");


    @Test
    public void linkedInIconTest() {
        LoginPage logIn = new LoginPage(getDriver());
        logIn.enterUserName("performance_glitch_user");
        LOG.info("UserName entered");
        logIn.enterPassword("secret_sauce");
        LOG.info("Password entered");
        logIn.clickLogInButton();
        LOG.info("Login successful");
        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.clickLinkedInIcon();
        LOG.info("LinkedIn icon click successful");
        LOG.info("Redirected to https://www.linkedin.com/company/sauce-labs/");
    }


}


