package orangehrm.project.tests;

import base.CommonAPI;
import orangehrm.project.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonAPI {

    @Test
    public void test(){
        LoginPage login = new LoginPage(getDriver());
    }


}
