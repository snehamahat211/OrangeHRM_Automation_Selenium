package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    public WebDriver driver;
    private By userfield = By.name("username");
    private By passwordfield = By.name("password");
    private By loginbutton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    public Homepage(WebDriver driver) {

        this.driver = driver;
    }

    public void setUsername(String username1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userfield)).sendKeys(username1);
    }
    public void setPassword(String password1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordfield)).sendKeys(password1);
    }

    public Mainpage clickLoginButton()
    {
        driver.findElement(loginbutton).click();
        return new Mainpage(driver);

    }






}
