package com.orangehrm.project.pages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(BuzzPage.class.getName());
    public BuzzPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[text()=' Share Photos']")
    WebElement SharePhotosButton;
    @FindBy(xpath = "(//textarea[@rows='1'])[2]")
    WebElement TextArea;
    @FindBy(xpath = "//input[@type='file']")
    WebElement AddPhoto;
    @FindBy(xpath = "(//div[@id='app']//button[@type=\"submit\"])[2]")
    WebElement ShareBtn;
    @FindBy(xpath = "//p[text()='Success']")
    WebElement ToastMessage;
    @FindBy(xpath = "//button[text()=' Most Recent Posts ']")
    WebElement MostRecentPostBtn;
    @FindBy(xpath = "(//div[@class='orangehrm-buzz-post-actions']//button)[1]")
    WebElement CommentIcon;
    @FindBy(xpath = "//input[@placeholder='Write your comment...']")
    WebElement CommentText;
    // click on Share Photo button
    // write text
    //upload the pic
    // click on Share
    //catch success message
    public void clickOnSharePhotosButton(){
        clickOn(SharePhotosButton);
        LOG.info("Share Photos Button clicked");
    }
    public void typeText(String text){
        type(TextArea,text);
        LOG.info("Text set to What's on your mind");
    }
    public void uploadImage(String ImagePath){
        AddPhoto.sendKeys(ImagePath);
        LOG.info("Image successfully uploaded");
    }
    public void clickOnShareBtn(){
        clickOn(ShareBtn);
        LOG.info("Share button clicked");
    }
    public String toastMessage(){
        String toastMessage = ToastMessage.getText();
        LOG.info("Toast message successfully captured");
        return toastMessage;
    }
    public void clickOnMostRecentPost(){
        clickOn(MostRecentPostBtn);
        LOG.info("Most recent post button clicked");
    }
    public void clickOnCommentIcon(){
        clickOn(CommentIcon);
        LOG.info("Comment icon clicked");
    }
    public void publishComment(String text){
        typeAndEnter(CommentText, text);
    }







}
