package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditInfo {
    private WebDriver driver;
    private By Dropdown= By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    private By Name=By.xpath(" //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private By Dropdown2=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    private By Username=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    public EditInfo(WebDriver driver) {
        this.driver = driver;
    }
    public void clickDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Dropdown)).click();
    }
    public void clickName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        WebElement inputfield =wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        String existingText=inputfield.getAttribute("value");
        for (int i = 0; i < existingText.length(); i++) {
            inputfield.sendKeys(Keys.BACK_SPACE);
        }
        inputfield.sendKeys("Sneha Mahat");

    }



}
