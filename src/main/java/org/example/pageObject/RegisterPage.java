package org.example.pageObject;

import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class RegisterPage {

    public static WebDriver webDriver;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath ="//a[.='Sign Up']")
    private WebElement buttonSignUp;

    public void clickButtonSignUp(){
        buttonSignUp.click();
    }

    @FindBy(xpath="//label[.='User']")
    private WebElement buttonCar;

    public void clickButtonCar(){
        buttonCar.click();
    }

    @FindBy(xpath ="//input[@name='fullname']")
    private WebElement fullName;

    public void fieldFullName(String fullname){
        fullName.sendKeys(fullname);
    }


    @FindBy(xpath="//input[@name='email']")
    private WebElement Email;

    public void fieldEmail(String email){
        Email.sendKeys(email);
    }

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    public void fieldPassword(String password){
        inputPassword.sendKeys(password);
    }

    @FindBy(xpath="//button[@class='inline-flex items-center justify-center whitespace-nowrap ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-primary-foreground hover:bg-primary/90 px-4 py-2 w-full h-full bg-gradient-to-r from-orange-500 to-yellow-500 rounded-2xl font-bold text-lg gap-2']")
    private WebElement clickSignUp;

    public void setClickSignUp(){
        clickSignUp.click();
    }

    @FindBy(xpath = "//li[1]/div[1]/div[.='selamat data sudah terdaftar']")
    private WebElement successRegister;

    public boolean getRegisterSuccess() {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]/div[1]/div[.='selamat data sudah terdaftar']")));
        return successRegister.isDisplayed();
    }

    @FindBy(xpath="//img[@alt='parkify']")
    private WebElement verifyLogin;

    public boolean verifyParkify() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='parkify']")));
        return verifyLogin.isDisplayed();
    }

}


