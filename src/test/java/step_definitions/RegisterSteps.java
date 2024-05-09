package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.LoginPage;
import org.example.PageObject.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterSteps {
    private final WebDriver driver = Hooks.driver;
    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);


    @When("User click sign up button")
    public void clickSignupButton(){
        loginPage.clickButtonSignup();
    }

    @Then("User redirected to register page")
    public void userRedirectedToRegisterPage() {

    }
}
