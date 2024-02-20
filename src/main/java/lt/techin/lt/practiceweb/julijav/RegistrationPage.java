package lt.techin.lt.practiceweb.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(xpath = "//input[@id='name']")
    WebElement nameInput;

    @FindBy(css = "#password")
    WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[text()='Register']")
    WebElement registerButton;

    @FindBy(xpath = "//h1[.='Register']")
    WebElement registrationElement;

    @FindBy(css = ".toast-body")
    WebElement errorMessageExistingEmail;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/div[1]/div[2]/div[1]/div")
    WebElement errorMessageShortPassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/div[1]/div[1]/div[2]/div")
    WebElement errorMessageWrongName;


    public void enterEmailAddress(String userEmail) {
        emailInput.sendKeys(userEmail);
    }

    public void enterName(String userName) {
        nameInput.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPassword.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();

    }

    public String getRegistrationElementText() {
        return registrationElement.getText();

    }
//    public boolean isDisplayedRegistrationElement() {
//         registrationElement.isDisplayed();
//
//    }


    public String getErrorMessageExistingEmailText() {
        return errorMessageExistingEmail.getText();

    }

    public String getErrorMessageShortPasswordText() {
        return errorMessageShortPassword.getText();

    }

    public String getErrorMessageWrongNameText() {
        return errorMessageWrongName.getText();

    }



    @FindBy(xpath = "//div[@class='invalid-feedback']")
    List<WebElement> registrationAllErrorMessages;
    @FindBy(xpath = "//input")
    WebElement errorEmptyRegistration;



    public boolean isRegistrationFormEmpty() {

        return errorEmptyRegistration.isDisplayed();
    }

    public boolean isErrorMessageDisplayed(String errorMessageText) {
        ArrayList<String> newErrorMessages = new ArrayList<>();
        for (WebElement errorMessage : registrationAllErrorMessages) {
            newErrorMessages.add(errorMessage.getText());
        }
        return newErrorMessages.contains(errorMessageText);
    }
}

//    @FindBy(css = "input#user-email")
//    WebElement profileEmail;
//    public String getProfileEmail(){
//    return profileEmail.getAttribute("value");
//}

//    @FindBy(css = ".btn.btn-outline-danger")
//    WebElement logoutButton;
//    public boolean isThereLogoutButton() {
//    return logoutButton.isDisplayed();
//    }







