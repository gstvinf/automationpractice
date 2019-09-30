package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Base;

import java.util.concurrent.TimeUnit;

import static utils.Driver.closeDriver;
import static utils.Driver.getDriver;

public class Hooks extends Base {

    @Before
    public static void setUp() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        closeDriver();
    }

}
