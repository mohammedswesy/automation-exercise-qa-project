package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
    //	WebDriverManager.chromedriver().setup();
    //	driver = new ChromeDriver();
    	driver = new EdgeDriver(); //used edge browser
    	
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    //@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}