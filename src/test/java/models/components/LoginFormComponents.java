package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormComponents {

    private final WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("#password");
    private final By loginBtnSel = By.cssSelector("[type='submit']");

    public LoginFormComponents(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String usernameText) {
        driver.findElement(usernameSel).sendKeys(usernameText);
    }

    public void inputPassword(String passwordText) {
        driver.findElement(passwordSel).sendKeys(passwordText);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtnSel).click();
    }
}
