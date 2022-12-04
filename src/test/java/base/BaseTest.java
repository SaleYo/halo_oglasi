package base;

import constants.Const;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

@Log
public abstract class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        log.info("setup");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(Const.BASE_URL);
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }

}
