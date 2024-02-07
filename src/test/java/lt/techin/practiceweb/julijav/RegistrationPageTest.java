package lt.techin.practiceweb.julijav;

import ch.qos.logback.classic.Logger;
import lt.techin.lt.practiceweb.julijav.*;
import lt.techin.practiceweb.julijav.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BasePageTest {
    MainPage mainPage;
    RegistrationPage registrationPage;
    SuccessfullyRegistrationPage successfullyRegistrationPage;
    LoginPage loginPage;
    String userName = "Martin";
    String userPassword = "Martin159";
    String userEmail = "martin321@gmail.com";
    String shortUserPassword = "123";
    String wrongUserName = "aaa";

    private final Logger log = (Logger) LoggerFactory.getLogger(RegistrationPageTest.class);

    @Test
    public void randomUserRegistration() {

        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickCreateAccountButton();
        registrationPage.enterEmailAddress(TestUtils.getRandomEmail());
        registrationPage.enterName(userName);
        registrationPage.enterPassword(userPassword);
        registrationPage.enterConfirmPassword(userPassword);
        registrationPage.clickRegisterButton();

        assertEquals("Register", registrationPage.getRegistrationElementText(), "Registration elementText should be 'Register'");
        assertEquals("User account created successfully", successfullyRegistrationPage.getRegistrationConfirmationMessage(), "Successfully registration should have this message 'User account created successfully'");
        successfullyRegistrationPage.clickLoginButton();
        assertEquals("Login", loginPage.findDesignLoginElementText(), "login element text should be 'Login' !!! ");
        log.info("Registration is successfully done!");
    }

    @Test
    public void existingUserRegistration() {

        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickCreateAccountButton();
        registrationPage.enterEmailAddress(userEmail);
        registrationPage.enterName(userName);
        registrationPage.enterPassword(userPassword);
        registrationPage.enterConfirmPassword(userPassword);
        registrationPage.clickRegisterButton();
        assertEquals("An account already exists with the same email address", registrationPage.getErrorMessageExistingEmailText(), "Error message should be 'An account already exists with the same email address'!!!");
        log.info("Registration with existing email brings error message! Test passed!");
    }

    @Test
    public void wrongUserNameRegistration() {

        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickCreateAccountButton();
        registrationPage.enterEmailAddress(TestUtils.getRandomEmail());
        registrationPage.enterName(wrongUserName);
//        registrationPage.enterName("aaa");
        registrationPage.enterPassword(userPassword);
        registrationPage.enterConfirmPassword(userPassword);
        registrationPage.clickRegisterButton();
        assertEquals("User name should be between 4 and 30 characters", registrationPage.getErrorMessageWrongNameText(), "Wrong Name error message should include this text: 'User name should be between 4 and 30 characters'");
        log.info("Error message displayed. Test - PASSED!");
      }

    @Test
    public void shortPasswordRegistration() {

        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickCreateAccountButton();
        registrationPage.enterEmailAddress(TestUtils.getRandomEmail());
        registrationPage.enterName(userName);
        registrationPage.enterPassword(shortUserPassword);
        registrationPage.enterConfirmPassword(shortUserPassword);
        registrationPage.clickRegisterButton();
        assertEquals("Password should be between 6 and 30 characters", registrationPage.getErrorMessageShortPasswordText(), "If password is too short - under input message should include 'Password should be between 6 and 30 characters'!!! ");
        log.info("Error message displayed. Test - PASSED!!");

    }

}
