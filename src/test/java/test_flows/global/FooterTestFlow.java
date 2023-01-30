package test_flows.global;

import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.components.global.header.TopMenuComponent;
import static models.components.global.header.TopMenuComponent.MainCatItem;
import static models.components.global.header.TopMenuComponent.CatItemComponent;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import url.UrlsDemoWebShop;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    
    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }
    
    public void verifyFooterComponent() {
        BasePage basePage = new BasePage(driver);
        FooterComponent footerComp = basePage.footerComp();
        verifyInformationColumn(footerComp.informationColumnComp());
        verifyCustomerServiceColumn(footerComp.customerServiceColumnComp());
//        verifyMyAccountColumn(footerComp.myAccountColumnComp());
//        verifyFollowUsColumn(footerComp.followUsColumnComp());
    }

    // Should put (InformationColumnComponent information)
    private void verifyInformationColumn(FooterColumnComponent footerColComp) {
        String baseUrl = UrlsDemoWebShop.baseUrl;
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use",
                "About us", "Contact us");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/sitemap", baseUrl + "/shipping-returns", baseUrl + "/privacy-policy", baseUrl + "/conditions-of-use",
                baseUrl + "/about-us", baseUrl + "/contactus");
        verifyFooterColumn(footerColComp, expectedLinkTexts, expectedHrefs);
    }

    // Should put (CustomerServiceColumnComponent customerService)
    private void verifyCustomerServiceColumn(FooterColumnComponent footerColComp) {
        String baseUrl = UrlsDemoWebShop.baseUrl;
        List<String> expectedLinkTexts = Arrays.asList(
                "Search", "News", "Blog", "Recently viewed products",
                "Compare products list", "New products");
        List<String> expectedHrefs = Arrays.asList(
                baseUrl + "/search", baseUrl + "/news", baseUrl + "/blog", baseUrl + "/recentlyviewedproducts",
                baseUrl + "/compareproducts", baseUrl + "/newproducts");
        verifyFooterColumn(footerColComp, expectedLinkTexts, expectedHrefs);
    }

    // Should put (MyAccountColumnComponent myAccount)
    private void verifyMyAccountColumn(FooterColumnComponent footerColComp) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        verifyFooterColumn(footerColComp, expectedLinkTexts, expectedHrefs);
    }

    // Should put (FollowUsColumnComponent followUs)
    private void verifyFollowUsColumn(FooterColumnComponent footerColComp) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        verifyFooterColumn(footerColComp, expectedLinkTexts, expectedHrefs);
    }

    public void verifyProductCatFooterComponent() {
        // Random pick up an item
        BasePage basePage = new BasePage(driver);
        TopMenuComponent topMenuComp = basePage.topMenuComp();
        List<MainCatItem> mainCatElems = topMenuComp.mainItemElems();
        if (mainCatElems.isEmpty())
            Assert.fail("[ERR] There is no item on top menu!");

        MainCatItem randomMainItemElem = mainCatElems.get(new SecureRandom().nextInt(mainCatElems.size()));
        String randomCatHref = randomMainItemElem.catItemLinkElem().getAttribute("href");

        // Get sublist
        List<CatItemComponent> catItemComps = randomMainItemElem.catItemComps();
        if (catItemComps.isEmpty())
            randomMainItemElem.catItemLinkElem().click();
        else {
            int randomIndex = new SecureRandom().nextInt(catItemComps.size());
            CatItemComponent randomCalItemComp = catItemComps.get(randomIndex);
            randomCatHref = randomCalItemComp.getComponent().getAttribute("href");
            randomCalItemComp.getComponent().click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(randomCatHref));

        // Verify footer component
        verifyFooterComponent();
    }

    private void verifyFooterColumn(
            FooterColumnComponent footerColComp, List<String> expectedLinkTexts, List<String> expectedHrefs) {

        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();

        for (WebElement link : footerColComp.linkElems()) {
            actualLinkTexts.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));
        }
        if (actualLinkTexts.isEmpty() || actualHrefs.isEmpty())
            Assert.fail("[ERR] Texts or Hyperlinks is empty in footer column!!");

        // Verify link text
        Assert.assertEquals(actualLinkTexts, expectedLinkTexts, "[ERR] Texts are different!");

        // Verify hrefs
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Hrefs are different!");
    }
}
