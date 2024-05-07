package step_definitions;

import com.ibm.dtfj.corereaders.Register;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.BookingPage;
import org.example.pageObject.EditProfilPage;
import org.example.pageObject.LoginUsr;
import org.example.pageObject.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.awt.print.Book;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterStep {

    private final WebDriver driver = Hooks.driver;
    RegisterPage registerPage = new RegisterPage(driver);

    @And("User click sign up button")
        public void sign (){
            registerPage.clickButtonSignUp();
        }


    @And("User click button role user")
    public void userClickButtonRoleUser() {

    }


    @When("User input {string} as fullname and {string} as email and {string} as password and click sign up")
    public void userInputAsFullnameAndAsEmailAndAsPasswordAndClickSignUp(String fullname, String email, String password) {
            registerPage.fieldFullName(fullname);
            registerPage.fieldEmail(email);
            registerPage.fieldPassword(password);
            registerPage.setClickSignUp();


    }

    @And("User will see success message {string}")
    public void userWillSeeSuccessMessage(String text) {
        Assert.assertTrue(registerPage.getRegisterSuccess());
    }


    @Then("User will redirected to login page")
    public void userWillRedirectedToLoginPage() {
        Assert.assertTrue(registerPage.verifyParkify());
    }


}

