package login;

import Base.BaseTests;
import Pages.DeleteAlert;
import Pages.EditInfo;
import Pages.Mainpage;
import Pages.UserTable;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test
    public void loginTest()
    {
        homepage.setUsername("Admin");
        homepage.setPassword("admin123");
        Mainpage mainpage=homepage.clickLoginButton();
        UserTable usertable=mainpage.clickAdmin();
        usertable.setDelete();
        DeleteAlert deletealert=usertable.setDeletefix();
        deletealert.clickDelete();


        EditInfo editinfo=usertable.setEditInfo();
        editinfo.clickDropdown();
        editinfo.clickName();





    }
}
