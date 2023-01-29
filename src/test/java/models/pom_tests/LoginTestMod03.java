package models.pom_tests;

import driver.DriverFactory;
import models.components.LoginFormComponents;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;

public class LoginTestMod03 {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get("http://the-internet.herokuapp.com/login");

            LoginPageMod03 loginPage = new LoginPageMod03(driver);
            LoginFormComponents loginFormComp = loginPage.loginFormComp();
            loginFormComp.inputUsername("teo@sth.com");
            loginFormComp.inputPassword("12345688");
            loginFormComp.clickLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
