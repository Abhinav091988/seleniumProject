package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinition.ShoppingCart;

public class ProductPage {

    WebDriver driver;
    SearchPage searchpage =new SearchPage(driver);
    public ProductPage(WebDriver driver){
        this.driver = driver;
       /** if(!driver.getTitle().equals(searchpage.getSearchProductName())){
            throw new IllegalStateException("This is not Product Page," +
                    " current page is: " + driver.getCurrentUrl());
        }**/
    }

    private String ProductPrice;
    private final By productName = By.xpath("//*[@id='content']//h1[contains(text(),'"+searchpage.SearchProductName+"')]");
    //private final By productPrice = By.xpath("//*[@id='content']//h1[contains(text(),'"+searchpage.SearchProductName+"')]//parent::div//ul[2]/li/h2");
    private final By productPrice = By.xpath("//*[@id='content']/div/div[2]/ul[2]/li[1]/h2");
    private final By addToCartBtn = By.xpath("//*[@id='button-cart']");
    private final By addToCartSuccessMsg = By.xpath("//div[@id = 'product-product']/div");
    private final By addedProductLink = By.xpath("//div[@id = 'product-product']/div/a[1]");
    private final By shoppingCartLink = By.xpath("//div[@id = 'product-product']/div/a[2]");



    public String getNameOfProduct(){
        return driver.findElement(productName).getText();
    }

    public String getProductPrice(){
            return ProductPrice.replace("$","");
    }

    public void setProductPrice() {
        ProductPrice = driver.findElement(productPrice).getText();
    }

    public void clickOnAddToCartButton(String element){
        if(element.equals("Add to cart")){
            driver.findElement(addToCartBtn).click();
        }
    }

    public String getSuccessMsg(){
        return driver.findElement(addToCartSuccessMsg).getText();

    }

    public String getText(String str){

        if(str.equals(searchpage.getSearchProductName())){
            return driver.findElement(addedProductLink).getText();
        }
        if (str.equals("shopping cart")){
            return driver.findElement(shoppingCartLink).getText();
        }
        return str;
    }

    public CheckOutCartPage clickOnLink(){
        driver.findElement(shoppingCartLink).click();
        return new CheckOutCartPage(driver);
    }

}
