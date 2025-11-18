package buzz;

import Base.BaseTests;
import org.testng.annotations.Test;

public class buzztest extends BaseTests {
    @Test
    public void buzztest()
    {
        homepage.setUsername("Admin");
        homepage.setPassword("admin123");

    }
}
