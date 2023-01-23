package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("http://the-internet.herokuapp.com/login");

            // Define selector values
            By loginInputFieldSels = By.tagName("input");

            // Interaction
            List<WebElement> loginFormFieldElems = driver.findElements(loginInputFieldSels);
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            if (!loginFormFieldElems.isEmpty()) {
                loginFormFieldElems.get(USERNAME_INDEX).sendKeys("teo@sth.com");
                loginFormFieldElems.get(PASSWORD_INDEX).sendKeys("12345688");
            } else {
//                Assert.fail("........");
            }

            // DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
