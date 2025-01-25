package predefined;
import io.cucumber.java.en.Given;

import static hooks.DriverManager.getDriver;

public class PredefinedSteps {
    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        getDriver().get(url);
    }
}
