package login;

import Base.BaseTests;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test
    public void loginTest()
    {
        homepage.setUsername("Admin");
        homepage.setPassword("admin123");
        homepage.clickLoginButton();

    }
}
