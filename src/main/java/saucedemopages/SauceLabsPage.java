package saucedemopages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class SauceLabsPage extends CommonAPI {

        @FindBy(xpath = "//ul[@class='nav-menu-list']//div[@class='nav-menu-main-link']")
        WebElement pricingButton;

        @FindBy(xpath = "//span[contains(text(),'Terms of Service')]")
        WebElement termsOfService;

        @FindBy(xpath = "//body/div[@id='template__page']/div[1]/section[2]/div[1]/div[2]/div[7]/a[1]")
        private WebElement visualTesting;

        @FindBy(xpath = "//body/div[4]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")
        private WebElement EEA;

        @FindBy(xpath = "/html[1]/body[1]/div[5]/div[2]/figure[1]/lite-youtube[1]")
        private WebElement startVideo;

        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[4]/form[1]/button[1]/i[1]/*[1]")
        private WebElement searchButton;

        @FindBy(xpath = "//h2[contains(text(),'Test Automation')]")
        private WebElement testAutomation;

        @FindBy(xpath = "//span[contains(text(),'Sign in')]")
        private WebElement signIn;

        @FindBy(xpath = "//p[contains(text(),'Cross Browser Testing, Selenium Testing, Mobile Te')]")
        private WebElement searchSauceLink;

        @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[2]/div[1]/div[2]/div[4]/a[1]")
        private WebElement errorReporting;

        @FindBy(xpath = "//span[contains(text(),'Privacy')]")
        private WebElement privacy;

        @FindBy(xpath = "//a[contains(text(),'Cookies Settings')]")
        private WebElement cookiesSetting;

        @FindBy(xpath = "//body/div[@id='template__page']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")
        private WebElement videoLink;
        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[4]/form[1]/div[1]/input[1]")
        private WebElement searchBar;

        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[1]/div[1]/div[1]/a[1]")
        private WebElement solutions;

        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[2]/div[1]/div[1]/a[1]")
        private WebElement platform;

        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[4]/div[1]/div[1]/a[1]")
        private WebElement resources;

        @FindBy(xpath = "//button[contains(text(),'Confirm My Choices')]")
        private WebElement confirmChoices;

        @FindBy(xpath = "//span[contains(text(),'CCPA')]")
        private WebElement CCPA;

        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[5]/div[1]/div[1]/a[1]")
        private WebElement company;

        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[1]/ul[2]/li[6]/div[1]/div[1]/a[1]")
        private WebElement contact;

        @FindBy(xpath = "//a[contains(text(),'Terms and Conditions')]")
        private WebElement TermsAndConditions;

        @FindBy(xpath = "//header/nav[1]/a[1]/icon[1]/*[1]")
        private WebElement linkedInLogo;

        @FindBy(xpath = "//span[contains(text(),'Sign up with email')]")
        private WebElement SignUpWithEmail;

        @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
        private WebElement TryItFree;



        public SauceLabsPage(WebDriver driver){
            PageFactory.initElements(driver, this);
        }

        public void clickSignIn(){
            clickOn(signIn);
        }

        public void clickSearchButton(){
            clickOn(searchButton);
        }

        public void typeAndEnterSearchBar(String text){
            typeAndEnter(searchBar, text);

        }
        public void clickVisualTesting(){
            clickOn(visualTesting);
        }

        public void clickErrorReporting(){
            clickOn(errorReporting);
        }


        public void clickTestAutomation() {
            clickOn(testAutomation);
        }

        public void clickTermsOfService(){
            clickOn(termsOfService);
        }

        public void clickPrivacy(){
            clickOn(privacy);
        }

        public void clickEEA(){
            clickOn(EEA);
        }

        public void clickCCPA(){
            clickOn(CCPA);
        }

        public void clickCookiesSetting(){
            clickOn(cookiesSetting);

        }

        public void clickConfirmChoices(){
            clickOn(confirmChoices);

        }

        public void clickTryItFree(){
            clickOn(TryItFree);
        }

        public void clickTermsAndConditions(){
            clickOn(TermsAndConditions);
        }

        public void clickSignUpWithEmail(){
            clickOn(SignUpWithEmail);}

        public void clickSauceLink(){
            clickOn(searchSauceLink);}

    }






