package Base;

import Pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class BaseTests {
    private WebDriver driver;
    protected Homepage homepage;

    @Test
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        homepage = new Homepage(driver);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
