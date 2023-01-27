package nopcommerce.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends CommonAPI {
    public SearchPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    Logger log = LogManager.getLogger(SearchPage.class.getName());

    @FindBy(xpath = "//h2[@class='product-title']/a")
    WebElement itemName;
    @FindBy(css = ".price.actual-price")
    WebElement itemPrice;

    public String getItemName(){
        log.info("get item name success");
        return itemName.getText();
    }
    public String getItemPrice(){
        log.info("get item price success");
        return itemPrice.getText();
    }
}
