package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.LoginUsr;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginUsrStep {

    private final WebDriver driver = Hooks.driver;

    LoginUsr loginUser = new LoginUsr(driver);

    @Given("User open the app parkify")
    public void userOpenTheAppParkify() {
        Assert.assertTrue(loginUser.verifyLogin());
    }

    @When("User input {string} as username and {string} as password and click login")
    public void credential(String username, String password) {
        loginUser.inputFieldUserName(username);
        loginUser.inputFieldPassword(password);
        loginUser.clickButtonLogin();
    }

    @Then("User already on dashboard page")
    public void userAlreadyOnDashboardPage()  {
        Assert.assertTrue(loginUser.verifyLabel());

    }


    @Then("User see {string} as error text for {string}")
    public void userSeeAsErrorText(String text, String element) {
       Assert.assertEquals(text, loginUser.clickAddToCartItem(element));
    }
}
