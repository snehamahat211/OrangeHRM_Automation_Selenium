package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BuzzPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By describe = By.xpath("//textarea[contains(@class,'oxd-buzz-post-input')]");
    private By post=By.xpath("By postButton = By.xpath(//button[contains(@class,'oxd-buzz-post-button')]");

    public BuzzPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void writedescribe(String text) {
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(describe));
        box.click();
        box.sendKeys(text);
    }
    public void clickBuzz() {
        WebElement postbox = wait.until(ExpectedConditions.elementToBeClickable(post));
        postbox.click();


    }
}
