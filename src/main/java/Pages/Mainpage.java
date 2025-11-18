package Pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Mainpage  {
    public WebDriver driver;
    private By admin = By.xpath("//span[text()='Admin']");
    private By buzz = By.xpath("//span[text()='Buzz']");




    public Mainpage(WebDriver driver) {
        this.driver =driver;

    }

    public UserTable clickAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(admin)).click();
        return new UserTable(driver);
    }

    public Addpage clickUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(admin)).click();
        return new Addpage(driver);
    }

    public BuzzPage  clickBuzz() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buzz)).click();
        return new BuzzPage(driver);

    }
}
