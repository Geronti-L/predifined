package predefined;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import static hooks.DriverManager.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PredefinedSteps {
    @Given("I navigate to {string}")
    public void I_navigate_to(String url) {
        getDriver().get(url);
    }

    @Then("title should be {string}")
    public void titleShouldBe(String title) {
      String actualTitle= getDriver().getTitle();
       assertThat(actualTitle,is(title));




    }

    @And("element with xpath {string} should be present")
    public void elementWithXpathShouldBePresent(String xpath) {
    getDriver().findElement(By.xpath(xpath)).isDisplayed();


    }

    @When("I type {string} into element with xpath {string}")
    public void iTypeIntoElementWithXpath(String searchWord, String xpath) throws InterruptedException {
        getDriver().findElement(By.xpath(xpath)).sendKeys(searchWord);
        Thread.sleep(300);

    }

    @And("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String xpath) throws InterruptedException {
        getDriver().findElement(By.xpath(xpath)).click();
//        Thread.sleep(3000);
    }

    @And("I wait for element with xpath {string} to be present")
    public void iWaitForElementWithXpathToBePresent(String xpath) {
        getDriver().findElement(By.xpath(xpath)).isDisplayed();


    }

    @Then("element with xpath {string} should contain text {string}")
    public void elementWithXpathShouldContainText(String xpath, String text) throws InterruptedException {
        String ele=getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println(ele);
        assertTrue("The string contains value", ele.contains(text));
//       assertTrue("check",ele.endsWith("t"));

    }

    @Then("I wait {int} seconds")
    public void iWaitSeconds(int secs) throws InterruptedException {
        Thread.sleep(secs*1000);
    }

    @And("then I hit enter")
    public void thenIHitEnter() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.RETURN).perform();
    }

    @Then("I extract canvas value and print it in console")
    public void iExtractCanvasValueAndPrintItInConsole() throws IOException, TesseractException {

        WebElement canvas = getDriver().findElement(By.xpath("//canvas[@id='canvas']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        String base64Data = (String) jsExecutor.executeScript(
                "return arguments[0].toDataURL('image/png').substring(22);", canvas);

        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
        String imagePath = "canvas-image.png";
        try (OutputStream os = new FileOutputStream(imagePath)) {
            os.write(decodedBytes);
        }

    }
}
