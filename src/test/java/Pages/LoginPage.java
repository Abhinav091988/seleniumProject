package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
     /**   if(!driver.getTitle().equals("Your Store")){
            throw new IllegalStateException("This is not Login Page," +
                    " current page is: " + driver.getCurrentUrl());
        }**/
    }

    private static final By MyAccount = By.xpath("//span[text() = 'My Account']");
    private static final By loginlink = By.xpath("//a[text() = 'Login']");
    private static final By EMailtxt = By.xpath("//input[@name = 'email']");
    private static final By Passwordtxt = By.xpath("//input[@id = 'input-password']");
    private static final By Loginbtn = By.xpath("//input[@value = 'Login']");
    private static final By message = By.xpath("//*[@id='account-login']/div[1]");
    private static final By forgotpasswordlink = By.xpath("//a[text()='Forgotten Password']");
    private static final By forgotPwdtxt = By.xpath("//div[@id='content']/h1");
    private static final By continueBtn = By.xpath("//input[@value= 'Continue']");

    public void clickOnLogin(){
        driver.findElement(MyAccount).click();
        driver.findElement(loginlink).click();
    }

    public void enterEmail(String text){
       driver.findElement(EMailtxt).sendKeys(text);
    }

    public void enterPassword(String text){
        driver.findElement(Passwordtxt).sendKeys(text);
    }

    public AccountPage clickOnLoginbtn()  {
        driver.findElement(Loginbtn).click();
         return new AccountPage(driver);
    }

    public String getMessageText(){

       return driver.findElement(message).getText();
    }

    public void clickOnForgottenPassword(){

        driver.findElement(forgotpasswordlink).click();
    }

    public String getForgotPwdTxt(){

        return driver.findElement(forgotPwdtxt).getText();
    }

    public String getTitle(){

        return driver.getTitle();
    }

    public void clickOnContinueBtn(){
        driver.findElement(continueBtn).click();

    }
}
