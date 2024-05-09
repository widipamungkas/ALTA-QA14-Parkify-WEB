package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParkingSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    AddParkingLocationPage addParkingLocationPage = new AddParkingLocationPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    AddParkingSlotPage addParkingSlotPage = new AddParkingSlotPage(driver);

    @When("User click plus icon")
    public void clickPlusButton(){
        dashboardPage.clickPlusButton();
    }

    @Then("User redirected to Add Parking Location page")
    public void userRedirectedToAddParkingLocationPage() {
        Assert.assertTrue(addParkingLocationPage.verifyParkingLocation());
    }

    @And("User input {string} as location name and {string} as city")
    public void userInputAsLocationNameAndAsCity(String location, String city) {
        addParkingLocationPage.inputLocationField(location);
        addParkingLocationPage.inputCityField(city);
    }
    
    @And("User upload image and click confirm button")
    public void userUploadImageAndClickConfirmButton() {
        addParkingLocationPage.uploadImageValid();
        loginPage.clickButtonSubmit();
    }

    @Then("User redirected to profile page")
    public void userRedirectedToProfilePage() {
        profilePage.verifyProfile();
    }

    @And("User will see {string} as pop up message")
    public void userWillSeeAsPopUpMessage(String text) {
        Assert.assertEquals(text, profilePage.popupSuccess(text));
    }

    @And("User upload invalid image and click Confirm button")
    public void userUploadInvalidImageAndClickConfirmButton() {
        addParkingLocationPage.uploadImageInvalid();
        loginPage.clickButtonSubmit();
    }

    @When("User click profile button")
    public void userClickProfileButton() {
        dashboardPage.clickProfileButton();
    }

    @And("User click Manage My Parking")
    public void userClickManageMyParking() {
        profilePage.clickManageParking();
    }

    @Then("User redirected to Add Parking Slot page")
    public void userRedirectedToAddParkingSlotPage() {
        Assert.assertTrue(addParkingSlotPage.VerifyParkingSlotPage());

    }

    @And("User click the image")
    public void userClickTheImage() {
        addParkingSlotPage.clickImage();
    }

    @Then("User redirected to Edit Parking Location page")
    public void userRedirectedToEditParkingLocationPage() {
        addParkingLocationPage.verifyParkingLocation();
    }

    @And("User upload edit image and click confirm button")
    public void userUploadEditImageAndClickConfirmButton() {
        addParkingLocationPage.uploadImageEdit();
        loginPage.clickButtonSubmit();
    }

    @Then("User select vehicle type car then input {} as floor, {} as slot and {} as price and click submit")
    public void userSelectVehicleTypeCarThenInputAsFloorAsSlotAndAsPriceAndClickSubmit(int floor, int slot, int price) {
        addParkingSlotPage.inputFloorField(floor);
        addParkingSlotPage.inputSlotField(slot);
        addParkingSlotPage.inputPriceField(price);
        loginPage.clickButtonSubmit();
    }
}
