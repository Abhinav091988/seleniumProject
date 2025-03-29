package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    String SearchProductName;
    private final By searchText = By.xpath("//input[@name = 'search']");
    private final By searchClick = By.xpath("//div[@id= 'search']//button");
    private final By productName = By.xpath("//*[@class='product-thumb']/div[2]//a");

    public String getSearchProductName(){
        return SearchProductName;
    }

    public void setSearchProductName(String productname){
        System.out.println("-------------------"+productname);
        SearchProductName = productname.trim();
    }

    public void enterAndClickSearch(String productname){

        driver.findElement(searchText).sendKeys(productname);
        driver.findElement(searchClick).click();

    }

    public void getProductName(){

        driver.findElement(productName).getText();
    }



    public String getText(){

        SearchProductName =  driver.findElement(productName).getText();
        return SearchProductName;
    }

    public ProductPage clickOnProductName(){
        driver.findElement(productName).click();
        return new ProductPage(driver);
    }

}
