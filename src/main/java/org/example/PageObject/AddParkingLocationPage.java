package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class AddParkingLocationPage {
    public static WebDriver webDriver;
    public AddParkingLocationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver = driver;
    }

    @FindBy(xpath = "//input[@name='location']")
    private WebElement fieldLocation;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement fieldCity;

    public boolean verifyParkingLocation(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='location']")));
        boolean a = fieldLocation.isDisplayed();
        boolean b = fieldCity.isDisplayed();
        return a && b;

    }
    public void inputLocationField(String location){
        fieldLocation.sendKeys(location);
    }
    public void inputCityField(String city){
        fieldCity.sendKeys(city);
    }
    public void uploadImageValid(){
        File uploadFile = new File("src/main/java/org/example/resources/image/basura.jpg");

        WebElement fileInput = webDriver.findElement(By.id(":r4:-form-item"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());

    }
    public void uploadImageInvalid(){
        File uploadFile = new File("src/main/java/org/example/resources/image/azkaban.jpg");

        WebElement fileInput = webDriver.findElement(By.id(":r4:-form-item"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
    }
    public void uploadImageEdit(){
        File uploadFile = new File("src/main/java/org/example/resources/image/basura.jpg");

        WebElement fileInput = webDriver.findElement(By.cssSelector("[type='file']"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());

    }
}
