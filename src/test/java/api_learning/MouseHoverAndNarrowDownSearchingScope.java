package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.UrlsTheInternet;

import java.util.List;


public class MouseHoverAndNarrowDownSearchingScope implements UrlsTheInternet {

    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(hoversSlug));

            // Target parent elements
            List<WebElement> figureElems = driver.findElements(figureSel);
            if (figureElems.isEmpty())
                throw new RuntimeException("There is no profile image displayed!");

            // Define Actions object
            Actions actions = new Actions(driver);

            for (WebElement figureElem : figureElems) {
                WebElement profileNameElem = figureElem.findElement(profileNameSel);
                WebElement profileLinkElem = figureElem.findElement(profileLinkSel);

                // BEFORE mouse hover
                System.out.println(profileNameElem.getText() + "-" + profileNameElem.isDisplayed());
                System.out.println(profileLinkElem.getText() + "-" + profileLinkElem.isDisplayed());

                // Mouse hover
                actions.moveToElement(figureElem).perform();

                // AFTER mouse hover
                System.out.println(profileNameElem.getText() + "-" + profileNameElem.isDisplayed());
                System.out.println(profileLinkElem.getText() + "-" + profileLinkElem.isDisplayed());
            }

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
