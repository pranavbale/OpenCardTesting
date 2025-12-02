package testComponent;


import com.google.errorprone.annotations.ThreadSafe;
import com.pranavbale.resources.properties.GlobalData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

public class BaseTest {

    // create instance of WebDriver class
    public WebDriver driver;

    // initialize a browser for execution of code
    public WebDriver initializeDriver() throws IOException {

        // get browser from properties file
        String webDriver = GlobalData.loadProperties("browser");

        // initialize browser accordingly
        if (webDriver.equals("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);
        } else if (webDriver.equals("safari")) {
            driver = new SafariDriver();
        }

        // set an implicit wait and maximize window size
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // return a browser driver
        return driver;
    }

    // launch an application
    @BeforeMethod(alwaysRun = true)
    public void launchApplication() throws IOException {

        // initialize web Driver
        driver = initializeDriver();

        // get the Url
        driver.get(GlobalData.loadProperties("HomeURL"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication() {
//        try {
//            Thread.sleep(Duration.ofSeconds(10));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        driver.quit();
    }
}
