package run;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
		format ={"pretty","html:target/html"},
	    features = {"src/test/java/cucumberfeatures/myfeatures.feature" }
	    )//refer to Feature file
public class cucumberrunner {

}
