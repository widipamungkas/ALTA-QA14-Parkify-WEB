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

public class EditProfilPage {
    public static WebDriver webDriver;

    public EditProfilPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//div[.='Profile']")
    private WebElement profileName;

    public void click_icon_profile() {
        profileName.click();
    }

    @FindBy(css = ".lucide-square-pen")
    private WebElement editIcon;

    public void click_icon_edit() {
        editIcon.click();
    }

    @FindBy(xpath = "//input[@name='fullname']")
    private WebElement fieldEditUsername;

    public void input_edit_username(String username) {
        fieldEditUsername.sendKeys(username);
    }

    @FindBy(xpath = "//button[@id='updateProfile']")
    private WebElement updateProfileButton;

    public void click_update_profile() {
        updateProfileButton.click();
    }

    @FindBy(xpath = "//li[.='berhasil merubah profile']")
    private WebElement successMessage;

    public String getSucessMessage() {
        return successMessage.getText();
    }

    @FindBy(xpath = "//p[@class='text-white font-semibold text-3xl text-center mb-8']")
    private WebElement account;



    public boolean verifyProfile() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-white font-semibold text-3xl text-center mb-8']")));
        return account.isDisplayed();
    }

        @FindBy(xpath = "//p[.='Name']")
        private WebElement verifyAccount;

        public String verifyAccount() {
            return verifyAccount.getText();
    }

    public boolean getRegisterSuccessAlert() {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='berhasil merubah profile']")));
        return successMessage.isDisplayed();
    }

    public void clickAlertOk() {
        webDriver.switchTo().alert().accept();
    }

}
