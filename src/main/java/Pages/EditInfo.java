package Pages;

import org.openqa.selenium.*;
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
    private By checkpassword=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/label/span/i");

    public EditInfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // ---------- 🔁 REUSABLE HELPERS ----------


    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    private void click(By locator) {
        waitForElement(locator).click();
    }


    private void clearAndType(By locator, String text) {
        WebElement inputField = waitForElement(locator);
        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.BACK_SPACE);
        inputField.sendKeys(text);
    }



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
    public void setCheckbox(boolean check) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the "Invalid" field to disappear (or not visible)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Invalid']")));
        } catch (TimeoutException ignored) {
            System.out.println("Warning: Validation still visible — using JS click anyway");
        }

        WebElement checkbox = driver.findElement(checkpassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

        if (checkbox.isSelected() != check) {
            try {
                checkbox.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            }
        }
    }



    public void fillUserInfo(String name, String username) {
        selectFirstDropdown();
        enterName(name);
        selectSecondDropdown();
        enterUsername(username);
        setCheckbox(true);
    }
}
