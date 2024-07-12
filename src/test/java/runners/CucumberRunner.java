package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "pretty"
        },
        features = "src/test/resources/features",
        glue = "src/test/java/step_definitions",
        dryRun = true,
        tags = "@wip",
        publish = true //generating a report with public link

)
public class CucumberRunner {
}
