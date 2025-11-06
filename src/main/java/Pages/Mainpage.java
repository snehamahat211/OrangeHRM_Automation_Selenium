package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Mainpage  {
    public WebDriver driver;
    private By admin = By.xpath("//span[text()='Admin']");




    public Mainpage(WebDriver driver) {
        this.driver =driver;

    }

    public UserTable clickAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(admin)).click();
        return new UserTable(driver);
    }
}
