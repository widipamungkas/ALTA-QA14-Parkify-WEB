package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static WebDriver webDriver;
    public ProfilePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//div[@class='p-4 space-y-5']")
    private WebElement verifyProfile;
    @FindBy(xpath = "//a[@href='/parking-slot/61']")
    private WebElement buttonManageParking;

    public void verifyProfile(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='p-4 space-y-5']")));
        verifyProfile.isDisplayed();
    }
    public String popupSuccess(String text){
        String elementXpath = "//li[1]/div[1]/div[.='"+text+"']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement popupSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return popupSuccess.getText();
    }
    public void clickManageParking(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/parking-slot/61']")));
        buttonManageParking.click();
    }

}
