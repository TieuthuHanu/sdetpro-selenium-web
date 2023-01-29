package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitUntilElementEnabled;
import url.UrlsTheInternet;

import java.time.Duration;


public class DynamicControl implements UrlsTheInternet {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(dynamicControlSlug));

            // Define parent locators | 2 forms | checkbox form + input form
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            // Checkbox form interaction
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);;
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));
            if (!checkboxElem.isSelected())
                checkboxElem.click();

            // Input form interaction
            WebElement inputFormElem = driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputBtnElem = inputFormElem.findElement(By.tagName("button"));
            if (!inputFieldElem.isEnabled())
                inputBtnElem.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Use either way
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
            wait.until(new WaitUntilElementEnabled(By.cssSelector("#input-example input")));

            inputFieldElem.sendKeys("Hello World!");

            // DEBUG
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
