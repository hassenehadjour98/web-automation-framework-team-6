package nopcommerce.pages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends CommonAPI {
    public LogInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
