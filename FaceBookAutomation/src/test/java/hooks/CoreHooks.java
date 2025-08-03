package hooks;

import core.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ScreenshotUtils;

public class CoreHooks extends DriverFactory{
	
	@Before
	public void launchBrower() {
		super.setup();
	}
	
	@After
	public void clearScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			ScreenshotUtils.captureScreenshot(driver, scenario.getName());
		}
		super.tearDown();
	}
}
