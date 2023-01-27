package models.pom_tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;

public class LoginTestMod01 {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("http://the-internet.herokuapp.com/login");

            LoginPageMod01 loginPage = new LoginPageMod01(driver);
            loginPage.username().sendKeys("teo@sth.com");
            loginPage.password().sendKeys("12345688");
            loginPage.loginBtn().click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
