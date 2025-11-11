package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EditInfo {
    private WebDriver driver;
    private WebDriverWait wait;

    private By dropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    private By nameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private By dropdown2 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    private By usernameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private By checkpassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/label/span/i");
    private By password = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private By confirmpass = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private By save=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");

    public EditInfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }


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

    public void enterPassword(String cpassword) {
        clearAndType(password, cpassword);
    }

    public void enterConfirmPassword(String cfpassword) {
        clearAndType(confirmpass, cfpassword);
    }
    public void clickSave() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

        // Wait for the Save button to be present
        WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(save));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);

        try {
            saveButton.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        }
    }




    public void fillUserInfo(String name, String username, String cpassword, String cfpassword) {
        selectFirstDropdown();
        enterName(name);
        selectSecondDropdown();
        enterUsername(username);
        setCheckbox(true);


        if (!cpassword.equals(cfpassword)) {
            throw new AssertionError("Password and Confirm Password do not match!");
        }

        enterPassword(cpassword);
        enterConfirmPassword(cfpassword);


    }
}
