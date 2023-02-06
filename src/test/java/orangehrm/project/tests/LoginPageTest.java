package orangehrm.project.tests;

import base.CommonAPI;
import com.github.javafaker.Faker;
import com.orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ReadFromExcel;
import utility.Utility;

public class LoginPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPageTest.class.getName());
    ReadFromExcel readfromexcel = new ReadFromExcel("/Users/hassenehadjour/Desktop/web-automation-framework-team-6/Data/orangehrm/OrangeHRM.xlsx","LoginPage");
    Faker faker = new Faker();

    protected static String ValidUsernameOH = Utility.getProperties().getProperty("UsernameOH").trim();
    protected static String ValidPasswordOH = Utility.getProperties().getProperty("PasswordOH").trim();

    @Test
    public void LoginTest(){
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.setUsername(ValidUsernameOH);
        loginpage.setPassword(ValidPasswordOH);
        loginpage.clkOnLogin();
        LOG.info("login success");
        boolean flag = loginpage.DashboardTextDisplayed();

        Assert.assertTrue(true);
        LOG.info("Test LoginTest finished successfully finished");
    }
    @Test
    public void ResetPassword(){
        String data = readfromexcel.getDataFromCell(11,5);
        LoginPage loginpage = new LoginPage(getDriver());
        String ActualResult = loginpage.ResetPassword();
        String ExpectedResult = data;

        Assert.assertEquals(ActualResult, ExpectedResult);
        LOG.info("Test LoginTest ResetPassword successfully finished");
    }
    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData(){
        String invalidUserName = faker.name().username();
        String invalidPassword = faker.internet().password();
        Object[][] data={
                {invalidUserName,invalidPassword},
                {invalidUserName,ValidPasswordOH},
                {ValidUsernameOH,invalidPassword}
        }; return data;
    }
    @Test(dataProvider = "LoginDataProvider")
    public void LoginTestWithInvalidCredentials(String username, String password){
        String errorMsg=readfromexcel.getDataFromCell(14,5);

        LoginPage loginpage=new LoginPage(getDriver());

        loginpage.setUsername(username);
        loginpage.setPassword(password);
        loginpage.clkOnLogin();

        String ActualResult = loginpage.getErrorMessage();
        String ExpectedResult = errorMsg;

        Assert.assertEquals(ActualResult, ExpectedResult);
        LOG.info("Test LoginTestWithWrongCredentials successfully finished");
    }
    @Test
    public void LinkedinIconLink(){
        String SocialMedia ="Linkedin";
        String ExpectedTitle="LinkedIn";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.clkOnSocialMediaLink(SocialMedia);

        LoginPage.LinkedinPage linkedinPage = new LoginPage.LinkedinPage(getDriver());
        String CurrentTitle=linkedinPage.switchToLinkedinWindow(driver,SocialMedia);

        Boolean flag = loginpage.isTitleContains(CurrentTitle,ExpectedTitle);
        Assert.assertTrue(flag);
    }
    @Test
    public void FacebookIconLink(){
        String SocialMedia ="Facebook";
        String ExpectedTitle="Most Popular Opensource HRIS";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.clkOnSocialMediaLink(SocialMedia);

        LoginPage.FacebookPage facebookPage=new LoginPage.FacebookPage(getDriver());
        String CurrentTitle=facebookPage.switchToFacebookWindow(driver,SocialMedia);

        Boolean flag = loginpage.isTitleContains(CurrentTitle,ExpectedTitle);

        Assert.assertTrue(flag);
    }
    @Test
    public void TweeterIconLink(){
        String SocialMedia ="Tweeter";
        String ExpectedTitle="OrangeHRM";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.clkOnSocialMediaLink(SocialMedia);

        LoginPage.TweeterPage tweeterPage= new LoginPage.TweeterPage(getDriver());
        String CurrentTitle= tweeterPage.switchToTweeterWindow(driver,SocialMedia);

        Boolean flag = loginpage.isTitleContains(CurrentTitle,ExpectedTitle);
        Assert.assertTrue(flag);
    }
    @Test
    public void YouTubeIconLink(){
        String SocialMedia ="YouTube";
        String ExpectedTitle="YouTube";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.clkOnSocialMediaLink(SocialMedia);

        LoginPage.YouTubePage youtubePage = new LoginPage.YouTubePage(getDriver());
        String CurrentTitle=youtubePage.switchToYouTubeWindow(driver,SocialMedia);

        Boolean flag = loginpage.isTitleContains(CurrentTitle,ExpectedTitle);
        Assert.assertTrue(flag);
    }
    @Test
    public void OrangeHrmIncLink(){
        String SocialMedia ="http://www.orangehrm.com";
        String ExpectedTitle="OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM";

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.clkOnSocialMediaLink(SocialMedia);

        LoginPage.OrangeHrmInc orangeHrmInc = new LoginPage.OrangeHrmInc(getDriver());
        String CurrentTitle=orangeHrmInc.switchToOrangeHrmIncWindow(driver,SocialMedia);

        Assert.assertEquals(CurrentTitle,ExpectedTitle);
    }














}
