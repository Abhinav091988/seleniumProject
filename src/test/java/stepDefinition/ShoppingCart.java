package stepDefinition;

import Pages.CheckOutCartPage;
import Pages.ProductPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Browserfactory;

import java.util.Map;

public class ShoppingCart {

  //  Browserfactory factory = new Browserfactory();
    WebDriver driver = Browserfactory.getDriver();

    SearchPage searchgpage= new SearchPage(driver);
    ProductPage productpage= new ProductPage(driver);
    CheckOutCartPage checkoutcartpage = new CheckOutCartPage(driver);


    @When("User search for product {}")
    public void userSearchForProduct(String productName) {

        searchgpage.setSearchProductName(productName);
        searchgpage.enterAndClickSearch(productName);
    }

    @When("User clicks on product on search page")
    public void userClicksOnProductOnSearchPage() {
      // Assert.assertEquals(searchgpage.getText(),searchgpage.getSearchProductName());
        searchgpage.clickOnProductName();
    }

    @When("User gets the price of product")
    public void user_gets_the_price_of_product() {
        productpage.setProductPrice();
        System.out.println(productpage.getProductPrice());
    }

    @When("User clicks on {string} on product page")
    public void user_clicks_on_on_product_page(String string) {
        productpage.clickOnAddToCartButton(string);
    }

    @Then("User should get success message Success: You have added {} to your {string}")
    public void userShouldGetSuccessMessageSuccessYouHaveAddedToYour(String productLink, String shoppingCart) {
       //Success: You have added HP LP3065 to your shopping cart!\n×
       /** Assert.assertTrue(productpage.getSuccessMsg().contains("Success: You have added "));
        Assert.assertEquals(productpage.getText(productLink), searchgpage.getSearchProductName());
        Assert.assertEquals("shopping cart", productpage.getText(shoppingCart));**/

        String productname =productpage.getText(productLink);
        String shopcartlink = productpage.getText(shoppingCart);
        Assert.assertEquals("Success: You have added "+productname+" to your shopping cart!\n×", productpage.getSuccessMsg());

    }

    @When("User clicks on Shopping cart")
    public void user_clicks_on_shopping_cart() {
        productpage.clickOnLink();

    }

    @Then("User should validate same product name {} and price")
    public void userShouldValidateSameProductNameAndPrice(String str) {
        Map<String,String> map =  checkoutcartpage.getProductNameAndPrice();

        for(Map.Entry<String,String> entry : map.entrySet()){
            Assert.assertEquals(entry.getKey(), str);
            System.out.println(entry.getKey()+"-----"+str);
            Assert.assertEquals(entry.getValue(),productpage.getProductPrice());
            System.out.println(entry.getValue()+"------"+productpage.getProductPrice());
        }
    }



}
