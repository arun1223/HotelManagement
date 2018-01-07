package mwinteringham.step_definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		tags = {"@smoke"}
		)
public class RunCukesTest{
	public static Strinsg browser = "chrome";
	public static boolean remote = false;
}