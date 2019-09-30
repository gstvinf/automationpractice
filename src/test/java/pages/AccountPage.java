package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Base;

public class AccountPage extends Base {
    public AccountPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement welcomeText;

    public WebElement returnWelcome() {
        return welcomeText;
    }
}