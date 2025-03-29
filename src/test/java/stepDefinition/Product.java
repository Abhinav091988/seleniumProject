package stepDefinition;

import Pages.ProductPage;
import Pages.Registrationpage;
import org.openqa.selenium.WebDriver;
import utility.Browserfactory;

public class Product {
    WebDriver driver = Browserfactory.getDriver();
    ProductPage pp = new ProductPage(driver);

}
