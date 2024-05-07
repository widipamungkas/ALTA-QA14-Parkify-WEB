package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.EditProfilPage;
import org.example.pageObject.LoginUsr;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class EditProfilStep {

    private final WebDriver driver = Hooks.driver;

    EditProfilPage EditProfil = new EditProfilPage(driver);

    @And("User click profile icon")
    public void user_click_profile_icon() {

        EditProfil.click_icon_profile();
    }

    @And("User click edit icon")
    public void userClickEditIcon() {
        EditProfil.click_icon_edit();
    }


    @And("User input {string} as username")
    public void userInputAsUsername(String username) {
        EditProfil.input_edit_username(username);
    }

    @And("User click save changes button")
    public void userClickSaveChangesButton() {
        EditProfil.click_update_profile();
    }

    @And("User will see {string} as username changed")
    public void userWillSeeAsUsernameChanged(String alert) {
        Assert.assertTrue(EditProfil.getRegisterSuccessAlert());

    }

    @And("User will redirected to profile page")
    public void userWillRedirectedToProfilePage() {
        Assert.assertTrue(EditProfil.verifyProfile());
    }

    @And("User click refresh to see the changes")
    public void userClickRefreshToSeeTheChanges() {
        driver.navigate().refresh();
    }

    @Then("User will see the new name account {string}")
    public void userWillSeeTheNewNameAccount(String text) {
        Assert.assertEquals(text, EditProfil.verifyAccount());
    }
}
