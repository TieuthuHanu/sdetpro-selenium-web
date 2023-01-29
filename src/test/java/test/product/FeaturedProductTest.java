package test.product;

import driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.InformationColumnComponent;
import models.components.product.ProductItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.UrlsDemoWebShop;

import java.util.List;

public class FeaturedProductTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testFeaturedProductHomePage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    private static void testFeaturedProductHomePage(WebDriver driver) {
        driver.get(UrlsDemoWebShop.baseUrl);
        HomePage homePage = new HomePage(driver);
        List<ProductItemComponent> productItemComps = homePage.productGridComp().productItemComps();

        productItemComps.forEach(productItemComp -> {
            System.out.println(productItemComp.productTitleElem().getText());
            System.out.println(productItemComp.productTitleElem().getAttribute("href"));
            System.out.println(productItemComp.productLinkElem().getAttribute("href"));
        });
    }
}
