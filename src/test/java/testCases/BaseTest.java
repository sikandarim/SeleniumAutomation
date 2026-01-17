package testCases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String br){
        try {
            logger = LogManager.getLogger(this.getClass());
            FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            p = new Properties();
            p.load(file);
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid browser: " + br);
            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(p.getProperty("url"));
            driver.manage().window().maximize();



        } catch (Exception e) {
            logger.error("Failed to initialize test setup", e);
            throw new RuntimeException(e);

        }


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}