package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sessionLocationError")
    private WebElement textLocationError;

    @FindBy(id = "username")
    private WebElement inputUsername;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(id = "Laboratory")
    private WebElement buttonLaboratory;

    @FindBy(css = "#loginButton")
    private WebElement buttonLogin;

    @FindBy(css = "h4")
    private WebElement textLoginCheck;

    @FindBy(css = "#error-message")
    private WebElement textErrorMessage;

    @FindBy(css = "li[class='nav-item logout']>a")
    private WebElement buttonLogout;


    public WebElement getTextLocationError() {
        return textLocationError;
    }

    public WebElement getInputUsername() {
        return inputUsername;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonLaboratory() {
        return buttonLaboratory;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }

    public WebElement getTextLoginCheck() {
        return textLoginCheck;
    }

    public WebElement getTextErrorMessage() {
        return textErrorMessage;
    }

    public WebElement getButtonLogout() {
        return buttonLogout;
    }

}
