package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    protected WebDriver driver;

    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browser){

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equals("chrome")) {

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\funda\\OneDrive\\Belgeler\\chromedriver_win32\\chromedriver.exe");

            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }else if (browser.equals("firefox")){

            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\funda\\OneDrive\\Belgeler\\geckodriver-v0.31.0-win64\\geckodriver.exe");

            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }

        driver.manage().deleteAllCookies();

        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        driver.get("http://demowebshop.tricentis.com/");


    }

    @AfterClass
    public void tearDown(){

        //  driver.quit();
    }
}
