package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Includepage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Better/short XPaths
    private By roleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
    private By username = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By password = By.xpath("//label[text()='Password']/../following-sibling::div/input");
    private By confirmPassword = By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input");
    private By save = By.xpath("//button[@type='submit']");

    public Includepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // FIXED
    }

    private WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void click(By locator) {
        WebElement element = waitForVisible(locator);
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private void type(By locator, String text) {
        WebElement input = waitForVisible(locator);
        input.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        input.sendKeys(text);
    }

    // ---------------- ACTIONS ----------------

    public void selectUserRole() {
        click(roleDropdown);
    }

    public void enterEmployeeName(String empName) {
        type(employeeName, empName);
    }

    public void selectStatus() {
        click(statusDropdown);
    }

    public void enterUsername(String user) {
        type(username, user);
    }

    public void enterPassword(String pass) {
        type(password, pass);
    }

    public void enterConfirmPassword(String confirm) {
        type(confirmPassword, confirm);
    }

    public void clickSave() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(save));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);

        try {
            saveBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
        }
    }

    public void fillUserInfo(String empName, String user, String pass, String confirmPass) {

        selectUserRole();
        enterEmployeeName(empName);

        selectStatus();
        enterUsername(user);

        if (!pass.equals(confirmPass)) {
            throw new AssertionError("Password and Confirm Password do not match!");
        }

        enterPassword(pass);
        enterConfirmPassword(confirmPass);
    }
}
