package test.global.footer;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import url.UrlsDemoWebShop;

public class FooterTest {

    @Test()
    public void testFooterCategoryPage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(UrlsDemoWebShop.baseUrl);
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyProductCatFooterComponent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test()
    public void testFooterRegisterPage() {

    }

    @Test()
    public void testFooterLoginPage() {

    }

    @Test()
    public void testFooterHomePage() {

    }
}
