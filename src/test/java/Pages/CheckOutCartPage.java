package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckOutCartPage {

    WebDriver driver;
  //  SearchPage searchpage =new SearchPage(driver);
    public CheckOutCartPage(WebDriver driver){
        this.driver = driver;
      /**  if(!driver.getTitle().equals("Shopping Cart")){
            throw new IllegalStateException("This is not Checkout cart Page," +
                    " current page is: " + driver.getCurrentUrl());
        }**/
    }

    private final By ProductName = By.xpath("");

    public int getRowcount(){
        int rowcount =  driver.findElements(By.xpath("//div[@class='table-responsive']//tbody/tr")).size();
        System.out.println("rowcount of product added -----------"+rowcount);
        return rowcount;
    }

    public Map<String, String> getProductNameAndPrice(){
        Map<String,String> hsmp = new LinkedHashMap<>();
        for(int i = 1;i <= getRowcount();i++){
            String pm = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+i+"]/td[2]/a")).getText();
            String price = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody/tr["+i+"]/td[5]")).getText().replace("$","");
            hsmp.put(pm,price);
        }
       return hsmp;
    }


}
