package lt.techin.lt.practiceweb.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfullyRegistrationPage extends BasePage {
    public SuccessfullyRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='root']//div[2]/b")
    WebElement registrationConfirmationMessage;

    @FindBy(xpath = "//div[@class='text-center']//a[@class='text-decoration-none me-3']")
    WebElement buttonForLogin;

    public String getRegistrationConfirmationMessage() {
        return registrationConfirmationMessage.getText();
    }

    public void clickLoginButton() {
        buttonForLogin.click();
    }
}

