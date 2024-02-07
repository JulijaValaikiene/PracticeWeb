package lt.techin.lt.practiceweb.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//div[@id='root']//button[@type='submit']")
    WebElement registerButton;

    @FindBy(xpath = "//h1[.='Register']")
    WebElement registrationElement;

    @FindBy(css = ".toast-body")
    WebElement errorMessageExistingEmail;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/form/div[1]/div[2]/div[1]/div")
    WebElement getErrorMessageShortPassword;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/form/div[1]/div[1]/div[2]/div")
    WebElement getErrorMessageWrongName;

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

    public String findRegistrationElementText() {
        return registrationElement.getText();

    }
    public String errorMessageExistingEmailText() {
        return errorMessageExistingEmail.getText();

    }
    public String errorMessageShortPasswordText() {
        return getErrorMessageShortPassword.getText();

    }
    public String errorMessageWrongNameText() {
        return getErrorMessageWrongName.getText();

    }


}
