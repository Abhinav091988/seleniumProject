package utility;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    public Properties initializeProperties(){
        FileInputStream fis = null;
        Properties prop = new Properties();

        try {
             fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("No Data in file");
        }

        return prop;
    }
}
