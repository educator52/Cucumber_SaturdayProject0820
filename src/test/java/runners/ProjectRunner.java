package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions( plugin = {
        "html:target/cucumber-report",
        "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html" // extent report plugin
        },
        features = {"src\\test\\java\\featureFiles\\project150820.feature"},
        glue = "steps"
)
public class ProjectRunner extends AbstractTestNGCucumberTests {

}
