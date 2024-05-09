package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    public static WebDriver webDriver;
    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver = driver;
    }

    @FindBy(xpath = "//div[@class='h-full w-full relative']")
    private WebElement verifyDashboard;
    @FindBy(css = ".lucide-plus")
    private WebElement buttonPlus;
    @FindBy(xpath = "//a[.='Profile']")
    private WebElement buttonProfile;



    public boolean verifyDashboard(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='h-full w-full relative']")));
        return verifyDashboard.isDisplayed();
    }
    public void clickPlusButton(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".lucide-plus")));
        buttonPlus.click();
    }
    public void clickProfileButton(){
        buttonProfile.click();
    }
}
