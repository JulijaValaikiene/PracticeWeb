package lt.techin.lt.practiceweb.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='navbarSupportedContent']//a[@data-testid='profile']")
    WebElement profileButton;

    @FindBy(css = "input[name='name']")
    WebElement nameFromProfileSettings;

    public void clickProfileButton() {
        profileButton.click();
    }

    public String getNameFromProfileSettings() {
        return nameFromProfileSettings.getCssValue("name");
    }

}
