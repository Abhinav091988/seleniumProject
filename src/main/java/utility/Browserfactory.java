package utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browserfactory {

    static WebDriver driver;

    public static void initialiseBrowser(String BrowserName){

        if(BrowserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(BrowserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(BrowserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }

    }

    public static WebDriver getDriver(){

        return driver;
    }


}
