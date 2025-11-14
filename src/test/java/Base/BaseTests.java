package Base;

import Pages.Homepage;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class BaseTests {
    private WebDriver driver;
    protected Homepage homepage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        homepage = new Homepage(driver);
    }
    @AfterClass

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @AfterMethod
    public void takeFailedScreenshot(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                File screenshotDir = new File("resources/screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();
                }


                String filePath = "resources/screenshots/test_" + System.currentTimeMillis() + ".png";
                Files.copy(screenshot, new File(filePath));
                System.out.println("Screenshot saved: " + filePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
}
