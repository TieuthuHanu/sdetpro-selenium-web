package test.global.footer;

import driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.InformationColumnComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.UrlsDemoWebShop;

public class FooterTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        testFooterHomePage(driver);
        testFooterCategoryPage(driver);
        testFooterRegisterPage(driver);
        testFooterLoginPage(driver);

        driver.quit();
    }

    private static void testFooterHomePage(WebDriver driver) {
        driver.get(UrlsDemoWebShop.baseUrl);
        HomePage homePage = new HomePage(driver);

        InformationColumnComponent infoColComp = homePage.footerComp().informationColumnComp();
        CustomerServiceColumnComponent customerSerColComp = homePage.footerComp().customerServiceColumnComp();

        testFooterColumn(infoColComp);
        testFooterColumn(customerSerColComp);
    }

    private static void testFooterCategoryPage(WebDriver driver) {
    }

    private static void testFooterRegisterPage(WebDriver driver) {
    }

    private static void testFooterLoginPage(WebDriver driver) {
    }

    private static void testFooterColumn(FooterColumnComponent footerColComp) {
        System.out.println(footerColComp.headerElem().getText());
        footerColComp.linkElems().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
