package test.computer;

import models.components.order.CheapComputerComponent;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.computer.OrderComputerFlow;
import url.UrlsDemoWebShop;

public class BuyingCheapComputerTest extends BaseTest implements UrlsDemoWebShop {

    @Test
    public void testCheapComputerBuying() {
        driver.get(baseUrl.concat(buildCheapComputerSlug));

        OrderComputerFlow<CheapComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, CheapComputerComponent.class);

        orderComputerFlow.buildCompSpecAndAddToCart();
    }
}
