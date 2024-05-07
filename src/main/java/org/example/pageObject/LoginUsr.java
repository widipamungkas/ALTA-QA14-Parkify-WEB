package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginUsr {


    public static WebDriver webDriver;

    public LoginUsr(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath="//input[@name='email']")
    private WebElement fieldUsername;

    @FindBy(xpath="//input[@name='password']")
    private WebElement fieldpassword;

    @FindBy(xpath="//button[@class='inline-flex items-center justify-center whitespace-nowrap ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-primary-foreground hover:bg-primary/90 px-4 py-2 w-full h-full bg-gradient-to-r from-orange-500 to-yellow-500 rounded-2xl font-bold text-lg gap-2']")
    private WebElement buttonLogin;

    @FindBy(xpath="//div[@class='h-full w-full relative']")
    private WebElement dashboard;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;
    public void inputFieldUserName(String username){
        fieldUsername.sendKeys(username);
    }

    public void inputFieldPassword(String password){
        fieldpassword.sendKeys(password);
    }

    public void clickButtonLogin(){
        buttonLogin.click();
    }

    public boolean verifyLabel(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='h-full w-full relative']")));
        return dashboard.isDisplayed();
    }

    public boolean verifyLogin(){
        boolean a = fieldUsername.isDisplayed();
        boolean b = fieldpassword.isDisplayed();
        boolean c = buttonLogin.isDisplayed();
        return a && b && c;
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public String clickAddToCartItem(String item){
        String button = "//p[.='"+item+" is required']";
        return webDriver.findElement(By.xpath(button)).getText();


    }

}
