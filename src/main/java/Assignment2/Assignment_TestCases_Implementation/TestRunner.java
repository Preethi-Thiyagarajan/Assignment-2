package Assignment2.Assignment_TestCases_Implementation;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(
			plugin = {"pretty:target/cucumber/cucumber.txt", 
					"html:target/cucumber/cucumber-html-report",
					"json:target/cucumber/cucumber.json"
					}
			,features= {"Features"}
			,glue = {"stepDefinitions"}
			//,dryRun = true
			,tags="@Preethi"
			)
	public class TestRunner {

	}


