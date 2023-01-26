package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.*;
import url.Urls;


public class JsExecutor implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(floatingMenuSlug));

            // Scroll to bottom
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // DEBUG
            Thread.sleep(1000);

            // Scroll to top
            jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            // DEBUG
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
