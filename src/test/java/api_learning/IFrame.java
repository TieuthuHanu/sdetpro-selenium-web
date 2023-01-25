package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;


public class IFrame implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(iFrameSlug));

            // Locate iframe
            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElem = driver.findElement(iFrameSel);

            // Switch to iFrame
            driver.switchTo().frame(iFrameElem);

            // Locate element inside the iFrame
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("New text...");
            Thread.sleep(1000);

            // Switch back parent frame
            driver.switchTo().defaultContent();
            driver.findElement(By.linkText("Elemental Selenium")).click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
