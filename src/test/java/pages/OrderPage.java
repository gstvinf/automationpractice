package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Base;

import static utils.Util.scrollTo;

public class OrderPage extends Base {
    public OrderPage() {
        super();
    }

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a")
    private WebElement firstProduct;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a")
    private WebElement deletBtn;

    @FindBy(xpath = "//*[@id=\"cart_quantity_down_1_1_0_0\"]")
    private WebElement minusBtn;

    @FindBy(xpath = "//*[@id=\"cart_quantity_up_1_1_0_0\"]")
    private WebElement plusBtn;

    @FindBy(xpath = "//*[@id=\"product_1_1_0_0\"]/td[5]/input[2]")
    private WebElement quantityField;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement messageEmpty;

    @FindBy(id = "total_price")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    private WebElement proceedToAddress;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    private WebElement proceedToShipping;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    private WebElement proceedToPayment;

    @FindBy(id = "uniform-cgv")
    private WebElement thermsOfServiceCB;

    @FindBy(xpath = "//*[@id=\"order\"]/div[2]/div/div/div/div/p")
    private WebElement messageOfTherms;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    private WebElement bankWireBtn;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    private WebElement checkBtn;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    private WebElement confirmOrderBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]") //Your order on My Store is complete.
    private WebElement orderConfirmationByCheck;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong") //Your order on My Store is complete.
    private WebElement orderConfirmationByBankWire;

    public WebElement getOrderConfirmationByCheck() {
        return orderConfirmationByCheck;
    }

    public WebElement getOrderConfirmationByBankWire() {
        return orderConfirmationByBankWire;
    }

    public void confirmOrder() {
        scrollTo(confirmOrderBtn);
        confirmOrderBtn.click();
    }

    public void selectBankWire() {
        scrollTo(bankWireBtn);
        bankWireBtn.click();
    }

    public void selectCheck() {
        scrollTo(checkBtn);
        checkBtn.click();
    }

    public WebElement getMessageOfTherms() {
        return messageOfTherms;
    }

    public void checkTherms() {
        scrollTo(thermsOfServiceCB);
        thermsOfServiceCB.click();
    }

    public void proceedToPayment() {
        scrollTo(proceedToPayment);
        proceedToPayment.click();
    }

    public void proceedToShipping() {
        scrollTo(proceedToShipping);
        proceedToShipping.click();
    }

    public void proceedToAdress() {
        scrollTo(proceedToAddress);
        proceedToAddress.click();
    }

    public WebElement getFirstProduct() {
        return firstProduct;
    }

    public void deletItem() {
        deletBtn.click();
    }

    public WebElement getMessageEmpty() {
        return messageEmpty;
    }

    public void increaseQuantity() {
        plusBtn.click();
    }

    public void decreaseQuantity() {
        minusBtn.click();
    }

    public void typeQuantity(Object quantity) {
        quantityField.clear();
        quantityField.sendKeys(quantity.toString());
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }
}

