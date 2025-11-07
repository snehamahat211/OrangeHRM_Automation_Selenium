package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAlert {
    private WebDriver driver;
    private By alertDelete = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
    public DeleteAlert(WebDriver driver) {
        this.driver = driver;
    }
    public void clickDelete() {
        driver.findElement(alertDelete).click();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
