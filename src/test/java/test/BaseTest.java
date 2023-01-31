package test;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    public void initBrowserSession() {
        driver = DriverFactory.getChromeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowserSession() {
        if (driver != null)
            driver.quit();
    }

    @AfterMethod
    public void captureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // testMethodName-yyyy-mm-dd-hr-min-sec.png
            // 1. Test method name
            String methodName = result.getName();

            // 2. Get taken time
            Calendar calendar = new GregorianCalendar();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String filename = methodName+"-"+year+"-"+month+"-"+day+"-"+hour+"-"+min+"-"+sec+".png";

            // 3. Take screenshot
            File screenshotBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 4. Save and attach to Allure report
            try {
                String fileLocation = System.getProperty("user.dir") + "/screenshots/" + filename;
                FileUtils.copyFile(screenshotBase64Data, new File(fileLocation));

                Path content = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(content);
                Allure.addAttachment(methodName, inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
