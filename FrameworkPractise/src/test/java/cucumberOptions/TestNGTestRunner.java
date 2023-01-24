package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/searchProcucts.feature",glue="stepDefinations",
monochrome=true,tags="@cart")
//,dryRun=true
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
