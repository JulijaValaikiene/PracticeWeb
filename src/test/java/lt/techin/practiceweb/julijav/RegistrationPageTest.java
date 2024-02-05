package lt.techin.practiceweb.julijav;

import lt.techin.lt.practiceweb.julijav.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BasePageTest {
    MainPage mainPage;
    RegistrationPage registrationPage;
    SuccessfullyRegistrationPage successfullyRegistrationPage;
    LoginPage loginPage;
    AccountPage accountPage;
    String userName = "Martin";
    String userPassword = "Martin159";
    String userEmail = "martin321@gmail.com";


    protected String getRandomEmail() {
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";

        return RandomStringUtils.random(1, upperLetters)
                + RandomStringUtils.random(5, lowerLetters)
                + RandomStringUtils.random(3, numbers)
                + System.currentTimeMillis()
                + "@gmail.com";
    }

    @Test
    public void randomUserRegistration() {
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);
        loginPage = new LoginPage(driver);
        mainPage.clickCreateAccountButton();
        registrationPage.enterEmailAddress(getRandomEmail());
        registrationPage.enterName(userName);
        registrationPage.enterPassword(userPassword);
        registrationPage.enterConfirmPassword(userPassword);
        registrationPage.clickRegisterButton();
        assertEquals("Register", registrationPage.findRegistrationElementText(), "Registration elementText should be 'Register'");
        assertEquals("User account created successfully", successfullyRegistrationPage.getRegistrationConfirmationMessage(), "Successfully registration should have this message 'User account created successfully'");
        successfullyRegistrationPage.clickLoginButton();
        assertEquals("Login", loginPage.findDesignLoginElementText(), "login element text should be 'Login' !!! ");
    }

    @Test
    public void userLogin() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        loginPage.clickLoginButtonMainPage();
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPassword);
        loginPage.clickLoginButton();
        accountPage.clickProfileButton();
//        String actualUserName = accountPage.getNameFromProfileSettings();
//        assertEquals(userName, actualUserName, "Name should be the same: Martin !!!");

    }
}
