package lt.techin.lt.practiceweb.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='row mt-1']//h1")
    WebElement designLoginElement;
    @FindBy(xpath = "//div[1]/a[@href='/notes/app/login']")
    WebElement loginButtonMainPage;
    @FindBy(css = "#email" )
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@class='form-group']//button[@type='submit']")
    WebElement loginButton;

public String findDesignLoginElementText(){
    return designLoginElement.getText();
}
public void clickLoginButtonMainPage(){
    loginButtonMainPage.click();
}
public void enterEmail(String email){
    emailInput.sendKeys(email);
}
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

}
