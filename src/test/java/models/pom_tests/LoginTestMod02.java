package models.pom_tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;

public class LoginTestMod02 {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("http://the-internet.herokuapp.com/login");

            LoginPageMod02 loginPage = new LoginPageMod02(driver);
            loginPage.inputUsername("teo@sth.com");
            loginPage.inputPassword("12345688");
            loginPage.clickLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
