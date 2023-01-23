package orangehrm.project.tests;

import base.CommonAPI;
import orangehrm.project.pages.LoginPage;
import orangehrm.project.pages.MyInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(MyInfoTest.class.getName());
    @Test
    public void selectBloodType() throws InterruptedException {
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.logIn();

        MyInfo myinfo = new MyInfo(getDriver());
        myinfo.clickOnMyInfo();
        myinfo.selectBloodType();
        Thread.sleep(3000);
        myinfo.clickOnSave();

//        String Actualresult=myinfo.ToastMessage();
//        String Expectedresult = "Success";
//        Assert.assertEquals(Actualresult,Expectedresult);
    }
}
