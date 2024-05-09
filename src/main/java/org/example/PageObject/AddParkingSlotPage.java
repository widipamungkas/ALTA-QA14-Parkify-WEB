package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddParkingSlotPage {
    public static WebDriver webDriver;
    public AddParkingSlotPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver = driver;
    }

    @FindBy(xpath = "//div[@class='flex']")
    private WebElement clickImage;
    @FindBy(xpath = "//input[@name='floor']")
    private WebElement fieldFloor;
    @FindBy(xpath = "//input[@name='slot']")
    private WebElement fieldSlot;
    @FindBy(xpath = "//input[@name='price']")
    private WebElement fieldPrice;

    public boolean VerifyParkingSlotPage(){
        boolean a = fieldFloor.isDisplayed();
        boolean b = fieldSlot.isDisplayed();
        boolean c = fieldPrice.isDisplayed();
        return a && b && c;
    }
    public void clickImage(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex']")));
        clickImage.click();
    }
    public void inputFloorField(int floor){
        fieldFloor.sendKeys(String.valueOf(floor));
    }
    public void inputSlotField(int slot){
        fieldSlot.sendKeys(String.valueOf(slot));
    }
    public void inputPriceField(int price){
        fieldPrice.sendKeys(String.valueOf(price));
    }
}
