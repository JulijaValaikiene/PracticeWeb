package lt.techin.practiceweb.julijav;

import ch.qos.logback.classic.Logger;
import lt.techin.lt.practiceweb.julijav.*;
import lt.techin.practiceweb.julijav.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPageTest extends BasePageTest {
    MainPage mainPage;
    RegistrationPage registrationPage;
    SuccessfullyRegistrationPage successfullyRegistrationPage;
    LoginPage loginPage;
    String userName = "Martin";
    String userPassword = "Martin159";
    String existingUserEmail = "martin321@gmail.com";
    String shortUserPassword = "123";
    String wrongUserName = "aaa";

    private final Logger log = (Logger) LoggerFactory.getLogger(RegistrationPageTest.class);

    @Test
    public void randomUserRegistration() {

        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        successfullyRegistrationPage = new SuccessfullyRegistrationPage(driver);
        loginPage = new LoginPage(driver);
//        wait = new FluentWait<>(driver);

        mainPage.clickCreateAccountButton();
        registrationPage.enterEmailAddress(TestUtils.getRandomEmail());
        registrationPage.enterName(userName);
        registrationPage.enterPassword(userPassword);
        registrationPage.enterConfirmPassword(userPassword);
        registrationPage.clickRegisterButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Register']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[.='Register']")));
        assertEquals("Register", registrationPage.getRegistrationElementText(), "Registration elementText should be 'Register'");
//        assertEquals("User account created successfully", successfullyRegistrationPage.getRegistrationConfirmationMessage(), "Successfully registration should have this message 'User account created successfully");
//        String expectedInfoMessage = "User account created successfully";
//        String actualInfoMessage = successfullyRegistrationPage.getRegistrationConfirmationMessage();
//        assertEquals(expectedInfoMessage, actualInfoMessage, "Successfully registration should have this message" + expectedInfoMessage);


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
        registrationPage.enterEmailAddress(existingUserEmail);
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

    @ParameterizedTest
    @CsvFileSource(resources = "/registration_data.csv", numLinesToSkip = 2)
    void userRegistrationWithCsvFile(String emailCsv, String nameCsv, String passwordCsv, String passwordConfirmCsv, String messageErrorCsv) {
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);

        mainPage.clickCreateAccountButton();
        registrationPage.enterEmailAddress(emailCsv);
        registrationPage.enterName(nameCsv);
        registrationPage.enterPassword(passwordCsv);
        registrationPage.enterConfirmPassword(passwordConfirmCsv);
        registrationPage.clickRegisterButton();


        assertTrue(registrationPage.isErrorMessageDisplayed(messageErrorCsv), "Error message: " + messageErrorCsv);
//        assertEquals(,registrationPage.isMessageCsv(messageErrorCsv), "Error messages is equal ");
        System.out.println("Error message: " + messageErrorCsv);
        log.info("Parameterized Tests - PASSED!!");
    }

    @Test
    void userEmptyRegistration() {
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);

        mainPage.clickCreateAccountButton();
        registrationPage.clickRegisterButton();
        assertTrue(registrationPage.isRegistrationFormEmpty());
        log.info("Empty registration show up all required error messages - PASSED!!");
    }

    @Test
    void linkSplit(){
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);

        mainPage.clickCreateAccountButton();
        System.out.println(registrationPage.getPartOfTheTextOfLinkHomeMyNotes());
    }


}


