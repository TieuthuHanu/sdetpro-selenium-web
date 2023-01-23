package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextInteraction {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("http://the-internet.herokuapp.com/login");

            By poweredByLinkTextSel = By.linkText("Elemental Selenium");
//            By poweredByLinkTextSel = By.partialLinkText("Elemental");
            WebElement linkTextElem = driver.findElement(poweredByLinkTextSel);
            linkTextElem.click();

            // DEBUG
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
