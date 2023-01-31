package test.global.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.global.FooterTestFlow;
import url.UrlsDemoWebShop;

public class FooterTest extends BaseTest {

    @Test()
    public void testFooterCategoryPage() {
        driver.get(UrlsDemoWebShop.baseUrl);
        Assert.fail("Demo taking screenshot when test is failed!");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComponent();
    }

    @Test()
    public void testFooterHomePage() {
        driver.get(UrlsDemoWebShop.baseUrl);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }
}
