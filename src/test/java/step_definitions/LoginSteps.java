package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.DashboardPage;
import org.example.PageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Given("User open the web parkify")
    public void userOpenTheWebParkify(){
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("User input {string} as email and {string} as password and click login")
    public void userInputAsEmailAndAsPasswordAndClickLogin(String email, String password) {
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSubmit();
    }

    @Then("User already on dashboard page")
    public void userAlreadyOnDashboardPage() {
        Assert.assertTrue(dashboardPage.verifyDashboard());
    }

    @Then("User see {string} as error message")
    public void userSeeAsErrorMessage(String text) {
        Assert.assertEquals(text, loginPage.getErrorMessage());
    }

    @Then("User see {string} as error pop up")
    public void userSeeAsErrorPopup(String text) {
        Assert.assertEquals(text, loginPage.getErrorPopup());
    }

    @And("User click Confirm button")
    public void userClickConfirmButton() {
        loginPage.clickButtonSubmit();
    }
}
