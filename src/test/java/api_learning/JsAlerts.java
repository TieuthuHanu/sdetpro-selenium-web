package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JsAlerts implements Urls {

    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private final static By resultSel = By.cssSelector("#result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(jsAlertsSlug));

            // JS Alert
            handleAlert(driver, jsAlertSel, true);
            System.out.println("Result: " + driver.findElement(resultSel).getText());

            // JS Confirm
            handleAlert(driver, jsConfirmSel, false);
            System.out.println("Result: " + driver.findElement(resultSel).getText());

            // JS Prompt
            handleAlert(driver, jsPromptSel, "Java Script");
            System.out.println("Result: " + driver.findElement(resultSel).getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public static void handleAlert(WebDriver driver, By triggerJsBtnSel, boolean isAccepting) {
        Alert alert = getAlert(driver, triggerJsBtnSel);
        System.out.println("Alert content: " + alert.getText());
        if (isAccepting) {
            alert.accept();
        }
        else {
            alert.dismiss();
        }
    }

    public static void handleAlert(WebDriver driver, By triggerJsBtnSel, String textInput) {
        Alert alert = getAlert(driver, triggerJsBtnSel);
        System.out.println("Alert content: " + alert.getText());
        alert.sendKeys(textInput);
        alert.accept();
    }

    private static Alert getAlert(WebDriver driver, By triggerJsBtnSel) {
        WebElement triggerJsBtnElem = driver.findElement(triggerJsBtnSel);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        triggerJsBtnElem.click();
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
