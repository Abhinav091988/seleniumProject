package stepDefinition;



import Pages.AccountPage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Browserfactory;

public class Login {

  //  Browserfactory factory = new Browserfactory();
    WebDriver driver = Browserfactory.getDriver();
    LoginPage lp = new LoginPage(driver);
    AccountPage accountpage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
    lp.clickOnLogin();
    }

    @When("User enter {string} and {string} in email and password field")
    public void user_enter_and_in_email_and_password_field(String email, String pwd) {
    lp.enterEmail(email);
    lp.enterPassword(pwd);
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String string) {

        Assert.assertEquals(lp.getMessageText(),string);

    }

    @Given("User click the Login button")
    public void user_click_the_login_button() throws InterruptedException {
      accountpage =  lp.clickOnLoginbtn();
    }

    @When("User click the Forgot Password link")
    public void user_click_the_forgot_password_link() {
    lp.clickOnForgottenPassword();
    }

    @When("User should be redirected to the Forgot Password page")
    public void user_should_be_redirected_to_the_forgot_password_page() {
    Assert.assertEquals(lp.getForgotPwdTxt(),"Forgot Your Password?");
    }

    @When("User enters valid {string}")
    public void user_enters_valid(String string) {
        lp.enterEmail(string);
    }

    @When("User click on Continue button")
    public void user_click_on_continue_button() {
        lp.clickOnContinueBtn();
    }


    @Then("User should be redirected to the account dashboard")
    public void user_should_be_redirected_to_the_account_dashboard(){
        Assert.assertEquals("My Account", accountpage.getText());
    }

    @Then("User should be on Login page with success message {}")
    public void userShouldBeOnLoginPageWithSuccessMessage(String arg0) {
        Assert.assertEquals(lp.getMessageText(),arg0);
    }
}
