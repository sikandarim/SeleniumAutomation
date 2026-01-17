package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "terms")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        termsCheckbox.click();
        submitButton.click();
    }
}
