package stepDefinition;

import Pages.Registrationpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Browserfactory;

public class Registration {

   // Browserfactory factory = new Browserfactory();
    WebDriver driver = Browserfactory.getDriver();
    Registrationpage rp = new Registrationpage(driver);


    @Given("User on the registration page")
    public void user_on_the_registration_page(){
        rp.clickOnRegistration();
    }

    @When("User enter {string} {string} {string} {string} {string} {string} in the mandate field")
    public void user_enter_in_the_mandate_field(String string, String string2, String string3, String string4, String string5, String string6) {
        rp.enterMandatoryDetail(string,string2,string3,string4,string5,string6);
    }

    @When("User check the Privacy Policy checkbox")
    public void user_check_the_privacy_policy_checkbox() {
        rp.privacyPolicyCheckBox();
    }

    @When("User click the Continue button")
    public void user_click_the_continue_button() {
        rp.clickOnContinueBtn();
    }

    @Then("User should see a confirmation message {string} indicating successful registration")
    public void user_should_see_a_confirmation_message_indicating_successful_registration(String textmessage) {
        Assert.assertEquals(rp.getTextMessage(),textmessage);
    }

    @Then("User should see an error message {} for Privacy Policy")
    public void userShouldSeeAnErrorMessageForPrivacyPolicy(String ppmsg) {
        Assert.assertEquals(rp.getTextMessageWarning(),ppmsg);
    }

    @Then("User should see an error message {} for existing email ID")
    public void userShouldSeeAnErrorMessageForExistingEmailID(String existingEmailid) {
        Assert.assertEquals(rp.getTextMessageWarning(),existingEmailid);
    }



    @Then("User should get error message for {string} fields {}")
    public void userShouldGetErrorMessageForFields(String fieldname, String text) {

        Assert.assertEquals(rp.validationMsg(fieldname),text);
    }
}
