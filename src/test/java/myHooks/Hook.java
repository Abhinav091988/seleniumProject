package myHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Browserfactory;
import utility.ConfigReader;

import java.time.Duration;

public class Hook {

 //   Browserfactory factory = new Browserfactory();
    ConfigReader config = new ConfigReader();
    WebDriver driver;
    @Before
    public void setup(){

        Browserfactory.initialiseBrowser(config.initializeProperties().getProperty("browser"));
        driver = Browserfactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.initializeProperties().getProperty("url"));

    }

    @After
    public void teraDown(){
     //   driver.close();
        driver.quit();
    }
}
