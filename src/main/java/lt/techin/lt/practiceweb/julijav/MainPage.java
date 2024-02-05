package lt.techin.lt.practiceweb.julijav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{


        public MainPage(WebDriver driver) {
            super(driver);
        }
        @FindBy(xpath = "//div[@id='root']//a[@href='/notes/app/register']")
        WebElement createAccountButton ;

    public void clickCreateAccountButton(){

        createAccountButton.click();

    }
}
