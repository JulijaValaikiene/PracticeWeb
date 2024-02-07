package lt.techin.practiceweb.julijav;

import lt.techin.lt.practiceweb.julijav.AccountPage;
import lt.techin.lt.practiceweb.julijav.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BasePageTest{
    LoginPage loginPage;
    AccountPage accountPage;
    String userName = "Martin";
    String userPassword = "Martin159";
    String userEmail = "martin321@gmail.com";
    @Test
    public void userLoginTest() {

        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        loginPage.clickLoginButtonMainPage();
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPassword);
        loginPage.clickLoginButton();
        accountPage.clickProfileButton();
        String actualUserName = accountPage.getNameFromProfileSettings();
        assertEquals(userName, actualUserName, "Name should be the same: Martin !!!");
        accountPage.clickLogoutButton();
//        assertEquals("Login", mainPage.getLoginButtonText(), "Text should be 'Login'!!!" );
    }

}
