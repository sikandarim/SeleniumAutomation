package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Login;

public class LoginTest extends BaseTest{

    @Test
   public void login(){
        try {
            logger.info("****-Login Test-******");
            Login hp = new Login(driver);
            hp.login("rahulshettyacademy", "learning");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug los ..");
            Assert.fail();
        }



    }
}
