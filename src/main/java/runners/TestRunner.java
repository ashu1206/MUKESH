package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="F:\\Ln_Workspace\\com.clearTrips.project\\src\\resources\\flight_booking.feature",
		glue= {"stepDefinition"},
		monochrome= true
		)

public class TestRunner {

}
