package test.computer;

import models.components.order.StandardComputerComponent;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.computer.OrderComputerFlow;
import url.UrlsDemoWebShop;

public class BuyingStandardComputerTest extends BaseTest implements UrlsDemoWebShop {

    @Test
    public void testStandardComputerBuying() {
        driver.get(baseUrl.concat(buildStandardComputerSlug));

        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent.class);

        orderComputerFlow.buildCompSpecAndAddToCart();
    }
}
