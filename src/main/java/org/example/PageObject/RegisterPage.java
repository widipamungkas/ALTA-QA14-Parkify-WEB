package org.example.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public static WebDriver webDriver;
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }
}
