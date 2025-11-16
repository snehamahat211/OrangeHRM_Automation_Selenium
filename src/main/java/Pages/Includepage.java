package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Includepage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By user=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div");
    private By employee=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private By status=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    private By username=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private By password=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private By confirmpass=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private By save=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");

    public Includepage(WebDriver driver) {
        this.driver=driver;
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
        click(user);
    }

    public void enterName(String name) {
        clearAndType(username, name);
    }

    public void selectSecondDropdown() {
        click(status);
    }

    public void enterUsername(String username) {
        clearAndType(employee, username);
    }


    public void enterPassword(String cpassword) {
        clearAndType(password, cpassword);
    }

    public void enterConfirmPassword(String cfpassword) {
        clearAndType(confirmpass, cfpassword);
    }
    public void clickSaved() {
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



        if (!cpassword.equals(cfpassword)) {
            throw new AssertionError("Password and Confirm Password do not match!");
        }

        enterPassword(cpassword);
        enterConfirmPassword(cfpassword);


    }
}


