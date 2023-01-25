package Runner;

import io.cucumber.testng.*;

@CucumberOptions(
			features = "src/main/java/Features",
			glue={"stepDefinitions"}
						
			)
	 
	public class TestRunner extends AbstractTestNGCucumberTests {
	 
	}
	