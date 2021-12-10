package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AdminPage {

    public AdminPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".nav-item.identifier")
    private WebElement buttonAdmin;

    @FindBy(css = "ul[id='user-account-menu']>li>a")
    private WebElement buttonMyAccount;

    @FindBy(css = "i[class='icon-lock']")
    private WebElement buttonChangePassword;

    @FindBy(css = "i[class='icon-cog']")
    private WebElement buttonMyLanguages;

    @FindBy(css = "span[id='selected-location']")
    private WebElement selectedLocation;

    @FindBy(css = "li[locationname='Pharmacy']")
    private WebElement buttonLocationPharmacy;

    public WebElement getButtonAdmin() {
        return buttonAdmin;
    }

    public WebElement getButtonMyAccount() {
        return buttonMyAccount;
    }

    public WebElement getButtonChangePassword() {
        return buttonChangePassword;
    }

    public WebElement getButtonMyLanguages() {
        return buttonMyLanguages;
    }

    public WebElement getSelectedLocation() {
        return selectedLocation;
    }

    public WebElement getButtonLocationPharmacy() {
        return buttonLocationPharmacy;
    }
}
