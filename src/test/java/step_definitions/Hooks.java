package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @After
    public void teardownMethod(Scenario scenario){

        System.out.println("---> @After: RUNNING AFTER EACH SCENARIO");

        if (scenario.isFailed()){

            byte[] screenShot =
                    ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenShot,"image/png",scenario.getName());
        }

        Driver.closeDriver();

    }

}
