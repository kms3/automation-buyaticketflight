package automapractice.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class baseTest {
    protected static WebDriver driver;
    private static final String URL = "https://www.ryanair.com/gb/en";
    private static final String LOCAL_DRIVER = "src/test/java/automapractice/resource/chromedriver.exe";
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", LOCAL_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }
    @AfterClass
    public static void finishExecution(){
        //driver.quit();
    }
}