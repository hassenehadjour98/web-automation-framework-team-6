package orangehrm.project.tests;

import base.CommonAPI;
import com.orangehrm.project.pages.BuzzPage;
import com.orangehrm.project.pages.HomePage;
import com.orangehrm.project.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static orangehrm.project.tests.LoginPageTest.ValidPasswordOH;
import static orangehrm.project.tests.LoginPageTest.ValidUsernameOH;

public class BuzzPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(BuzzPageTest.class.getName());
    SoftAssert SoftAssert = new SoftAssert();

    String Feild = "Buzz";
    String filePath = "/Users/hassenehadjour/Desktop/web-automation-framework-team-6/Data/orangehrm/BuzzPageTest.png";
    String PostText="Enjoy The Beautiful Nature";
    String ToastMessage = "Success";
    @Test(enabled = false)
    public void PostAnImage(){

        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(ValidUsernameOH, ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Feild);

        String ActualMenuField =homepage.FieldConfirmation();
        String ExpectedMenuField= Feild.toLowerCase();

        SoftAssert.assertEquals(ActualMenuField,ExpectedMenuField);

        BuzzPage buzzpage = new BuzzPage(getDriver());
        buzzpage.clickOnSharePhotosButton();
        buzzpage.typeText(PostText);
        buzzpage.uploadImage(filePath);
        buzzpage.clickOnShareBtn();

        String ActualMessage= buzzpage.toastMessage();
        String ExpectedMessage= ToastMessage;

        Assert.assertEquals(ActualMessage, ExpectedMessage);
        LOG.info("Test PostAnImage finished successfully");
    }
    @Test
    public void addCommentToMostRecentPost(){
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.LoginAsAdmin(ValidUsernameOH, ValidPasswordOH);

        HomePage homepage = new HomePage(getDriver());
        homepage.clickOnMenuField(Feild);

        String ActualMenuField =homepage.FieldConfirmation();
        String ExpectedMenuField= Feild.toLowerCase();

        Assert.assertEquals(ActualMenuField, ExpectedMenuField);

        BuzzPage buzzpage = new BuzzPage(getDriver());
        buzzpage.clickOnMostRecentPost();
        buzzpage.clickOnCommentIcon();
        buzzpage.publishComment("Hello World");

        String Status = buzzpage.toastMessage();
        String ExpectedResult= "Success";

        Assert.assertEquals(Status, ExpectedResult);
        LOG.info("Test addCommentToMostRecentPost finished successfully");
    }

}

