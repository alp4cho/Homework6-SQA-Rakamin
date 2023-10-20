package saucedemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"saucedemo.stepDef"},
        //plugin = {"html:target/HTML_report.html"},
        plugin = {"pretty","json:target/cucumber.json"})
public class runner {
}
