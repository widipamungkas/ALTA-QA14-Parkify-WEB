package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static WebDriver webDriver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath="//input[@name='email']")
    private WebElement fieldEmail;
    @FindBy(xpath="//input[@name='password']")
    private WebElement fieldPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//*[contains(@id,'message')]")
    private WebElement errorMessage;
    @FindBy(css = "[data-title]")
    private WebElement errorPopup;
    @FindBy(xpath ="//a[.='Sign Up']")
    private WebElement signUpButton;

    public void inputFieldEmail(String username){
        fieldEmail.sendKeys(username);
    }
    public void inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }
    public void clickButtonSubmit(){
        buttonSubmit.click();
    }
    public boolean verifyLoginPage(){
        boolean a = fieldEmail.isDisplayed();
        boolean b = fieldPassword.isDisplayed();
        boolean c = buttonSubmit.isDisplayed();
        return a && b && c;
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }
    public String getErrorPopup() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-title]")));
        return errorPopup.getText();
    }
    public void clickButtonSignup(){
        signUpButton.click();
    }
}
