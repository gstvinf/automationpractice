package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Base;

public class SignInPage extends Base {
    public SignInPage() {
        super();
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    private WebElement errorMessage;

    @FindBy(id = "header_logo")
    private WebElement logo;

    public void typeEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void typePass(String pass) {
        passwordInput.sendKeys(pass);
    }

    public void signIn() {
        submitBtn.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void goHome() {
        logo.click();
    }
}
