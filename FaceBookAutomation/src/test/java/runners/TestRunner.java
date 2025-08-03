package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "src/test/resources/Feature Files",
			glue    = {"stepDefi","hooks"},
			plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
			monochrome=true
)

public class TestRunner extends AbstractTestNGCucumberTests{

}
