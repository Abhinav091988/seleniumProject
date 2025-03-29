package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {

    static WebDriver driver = Browserfactory.getDriver();

    public static void getScreenShot(String TestName){
        try{

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, new File("screenshot/"+TestName+".png"));
            System.out.println("Screenshot saved: " );
        }
        catch (IOException e){
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }

    }

}
