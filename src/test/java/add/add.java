package add;

import Base.BaseTests;
import Pages.Addpage;
import Pages.Homepage;
import Pages.Mainpage;

import org.testng.annotations.Test;

public class add extends BaseTests {
    @Test
    public void addtest() {
        homepage.setUsername("Admin");
        homepage.setPassword("admin123");
        Mainpage mainpage=homepage.clickLoginButton();
        Addpage addpage=mainpage.clickUser();
        addpage.clickAddbutton();


    }


}
