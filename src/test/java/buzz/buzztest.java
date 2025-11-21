package buzz;

import Base.BaseTests;
import Pages.BuzzPage;
import Pages.Mainpage;
import org.testng.annotations.Test;

public class buzztest extends BaseTests {
    @Test
    public void buzztest()
    {
        homepage.setUsername("Admin");
        homepage.setPassword("admin123");
        Mainpage mainpage=homepage.clickLoginButton();
        BuzzPage buzzpage=mainpage.clickBuzz();
        buzzpage.writedescribe("good innovation leads to success");




    }
}
