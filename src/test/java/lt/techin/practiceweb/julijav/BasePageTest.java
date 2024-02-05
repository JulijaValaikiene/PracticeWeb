package lt.techin.practiceweb.julijav;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasePageTest {

    WebDriver driver;
    String mainPageURL = "https://practice.expandtesting.com/notes/app";

    @BeforeEach

    void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get(mainPageURL);
    }
//    @AfterEach
//    void tearDown(){
//       if (driver != null) {
//            driver.quit();
//    }
}
