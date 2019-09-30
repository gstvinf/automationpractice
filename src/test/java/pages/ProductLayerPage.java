package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Base;

public class ProductLayerPage extends Base {
    public ProductLayerPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    private WebElement proceedBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    private WebElement successfulyMessage;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
    private WebElement closeLayerBtn;

    public WebElement getSuccessfulyMessage() {
        return successfulyMessage;
    }

    public void proceedToCart() {
        proceedBtn.click();
    }

    public void closeLayer() {
        closeLayerBtn.click();
    }
}
