package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Base;

import static utils.Driver.getDriver;
import static utils.Util.scrollTo;

public class LandingPage extends Base {
    public LandingPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]")
    private WebElement productCard;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement addCartBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private WebElement cartBtn;

    public void addTSirtToCart() {
        Actions action = new Actions(getDriver());
        scrollTo(productCard);

        action.moveToElement(productCard).moveToElement(addCartBtn).click().perform();
    }

    public void goCart() {
        cartBtn.click();
    }

}
