package add;

import Base.BaseTests;
import Pages.Addpage;
import Pages.Homepage;
import Pages.Includepage;
import Pages.Mainpage;

import org.testng.annotations.Test;

public class add extends BaseTests {
    @Test
    public void addtest() {
        homepage.setUsername("Admin");
        homepage.setPassword("admin123");
        Mainpage mainpage=homepage.clickLoginButton();
        Addpage addpage=mainpage.clickUser();
        Includepage includepage =addpage.clickAddbutton();
        includepage.fillUserInfo("sneha Mahat","sneha211","abcd123#","abcd123#");
//        includepage.clickSave();
        includepage.clickcancel();




    }


}
