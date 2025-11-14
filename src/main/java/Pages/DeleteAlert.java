package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteAlert {
    private WebDriver driver;
    private By alertDelete = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
    private By cancel=By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]");

    public DeleteAlert(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDelete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertDelete)).click();
    }

    public void clickCancel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".oxd-dialog-container-default")
        ));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancel)).click();
    }

}
