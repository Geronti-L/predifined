package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.TestNG;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"predefined", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                //inorder to have allure reports generated automatically
                // please uncomment following line
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",

                "json:target/cucumber.json"
        },
        publish = true,
        tags = "@bing"

)

public class TestRunner {
}