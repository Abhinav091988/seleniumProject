package myRunner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

import java.util.Locale;


@CucumberOptions(

        features = "src/test/resources/Features/Login.feature",
        glue = {"stepDefinition","myHooks"},

        plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html"
                }
)

@Listeners(listeners.TestListener.class)
public class TestRunner extends AbstractTestNGCucumberTests{

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting Test Execution");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test Execution Completed");
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
