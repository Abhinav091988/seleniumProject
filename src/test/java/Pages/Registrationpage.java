package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registrationpage {

    WebDriver driver;
    public Registrationpage(WebDriver driver){
        this.driver = driver;
    }

    public static By MyAccount = By.xpath("//span[text() = 'My Account']");
    public static By registerlink = By.linkText("Register");
    public static By firstnametxt = By.xpath("//input[@id = 'input-firstname']");
    public static By lastnametxt = By.xpath("//input[@id = 'input-lastname']");
    public static By emailtxt = By.xpath("//input[@id = 'input-email']");
    public static By telephonetxt = By.xpath("//input[@id = 'input-telephone']");
    public static By passwordtxt = By.xpath("//input[@id = 'input-password']");
    public static By pwdconfirmtxt = By.xpath("//input[@id = 'input-confirm']");
    public static By newletteryes_rdbtn = By.xpath("//input[@name = 'newsletter' and @value = '1']");
    public static By newletterno_rdbtn = By.xpath("//input[@name = 'newsletter' and @value = '0']");
    public static By privacyPolicy_chkbox = By.xpath("//input[@name = 'agree']");
    public static By continue_btn = By.xpath("//input[@value = 'Continue']");
    public static By account_creted  = By.xpath("//*[@id='content']/h1");
    public static By error_msg  = By.xpath("//*[@id='account-register']/div[1]");

    public static By firstname_validation  = By.xpath("//*[@id='input-firstname']//following-sibling::div");
    public static By lastname_validation  = By.xpath("//*[@id='input-lastname']//following-sibling::div");
    public static By email_validation  = By.xpath("//*[@id='input-email']//following-sibling::div");
    public static By telephone_validation  = By.xpath("//*[@id='input-telephone']//following-sibling::div");
    public static By password_validation  = By.xpath("//*[@id='input-password']//following-sibling::div");


    public void clickOnRegistration(){
        driver.findElement(MyAccount).click();
        driver.findElement(registerlink).click();
    }

    public void enterMandatoryDetail(String firstname,String lastname,String email,String telephone,String password,String confirmpwd){
        driver.findElement(firstnametxt).sendKeys(firstname);
        driver.findElement(lastnametxt).sendKeys(lastname);
        driver.findElement(emailtxt).sendKeys(email);
        driver.findElement(telephonetxt).sendKeys(telephone);
        driver.findElement(passwordtxt).sendKeys(password);
        driver.findElement(pwdconfirmtxt).sendKeys(confirmpwd);
    }

    public void newletterCheckBox(){
        System.out.println("by default is NO");
    }

    public void privacyPolicyCheckBox(){
        driver.findElement(privacyPolicy_chkbox).click();
    }

    public void clickOnContinueBtn(){
        driver.findElement(continue_btn).click();
    }

    public String getTextMessage(){

        return driver.findElement(account_creted).getText();
    }

    public String getTextMessageWarning(){

        return driver.findElement(error_msg).getText();
    }

    public String validationMsg(String fieldname){

        switch (fieldname) {
            case "first_name":

                return driver.findElement(firstname_validation).getText();
            case "last_name":

                return driver.findElement(lastname_validation).getText();
            case "emailId":

                return driver.findElement(email_validation).getText();
            case "telephone":

                return driver.findElement(telephone_validation).getText();
            case "password":

                return driver.findElement(password_validation).getText();
            default:
                System.out.println("not valid field");
                break;
        }
        return fieldname;
    }

}
