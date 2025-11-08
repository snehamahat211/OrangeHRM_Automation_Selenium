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
    private WebDriverWait wait;

    // Locators
    private By dropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    private By nameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private By dropdown2 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    private By usernameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");

    public EditInfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // ---------- 🔁 REUSABLE HELPERS ----------

    /** Waits for an element to be visible and returns it */
    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Clicks on any element */
    private void click(By locator) {
        waitForElement(locator).click();
    }

    /** Clears existing text and types new value */
    private void clearAndType(By locator, String text) {
        WebElement inputField = waitForElement(locator);
        inputField.sendKeys(Keys.CONTROL + "a");  // select all
        inputField.sendKeys(Keys.BACK_SPACE);     // clear
        inputField.sendKeys(text);                // type new value
    }

    // ---------- 🎯 PAGE ACTIONS ----------

    public void selectFirstDropdown() {
        click(dropdown);
    }

    public void enterName(String name) {
        clearAndType(nameInput, name);
    }

    public void selectSecondDropdown() {
        click(dropdown2);
    }

    public void enterUsername(String username) {
        clearAndType(usernameInput, username);
    }

    // ---------- 💡 FULL WORKFLOW ----------
    public void fillUserInfo(String name, String username) {
        selectFirstDropdown();
        enterName(name);
        selectSecondDropdown();
        enterUsername(username);
    }
}
