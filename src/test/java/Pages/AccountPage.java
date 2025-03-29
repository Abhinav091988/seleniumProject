package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;
    public AccountPage(WebDriver driver){
        this.driver = driver;
      /**  if(!driver.getTitle().equals("My Account")){
            throw new IllegalStateException("This is not Account page ,"+ "Current Page is - " +driver.getCurrentUrl());
        }**/
    }

   // private String accheader = "My Account";
    private By accountheader = By.xpath("//div[@id = 'content']/h2");

    public String getText(){

        return driver.findElement(accountheader).getText();
    }

    public String getTitle(){

        return driver.getTitle();
    }

}
