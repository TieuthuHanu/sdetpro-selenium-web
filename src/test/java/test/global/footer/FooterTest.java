package test.global.footer;

import driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import support.verification.Verifier;
import url.UrlsDemoWebShop;

public class FooterTest {

    @Test(priority = 1, dependsOnMethods = {"testFooterRegisterPage"})
    public void testFooterCategoryPage() {
    }

    @Test(priority = 2)
    public void testFooterRegisterPage() {
        String actual = "Cheo";
        String expected = "Pho";
//        Verifier.verifyEquals(actual, expected);

        // Hard assertion
        Assert.assertEquals(actual, expected, "[ERR] Welcome message is incorrect!");
        Assert.assertTrue(actual.equals(expected), "......");
        Assert.assertFalse(actual.equals(expected), "......");
        Assert.fail();
        Assert.fail("......");
    }

    @Test(priority = 3)
    public void testFooterLoginPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2);
        softAssert.assertEquals(true, true);
        softAssert.assertEquals(3, 2);

        softAssert.assertAll();

        System.out.println("Hello");
    }

//    @Test(priority = 4)
    public void testFooterHomePage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(UrlsDemoWebShop.baseUrl);
        try {
            HomePage homePage = new HomePage(driver);
            InformationColumnComponent infoColComp = homePage.footerComp().informationColumnComp();
            CustomerServiceColumnComponent customerSerColComp = homePage.footerComp().customerServiceColumnComp();

            testFooterColumn(infoColComp);
            testFooterColumn(customerSerColComp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    private static void testFooterColumn(FooterColumnComponent footerColComp) {
        System.out.println(footerColComp.headerElem().getText());
        footerColComp.linkElems().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
