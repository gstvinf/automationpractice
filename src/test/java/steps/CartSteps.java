package steps;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LandingPage;
import pages.OrderPage;
import pages.ProductLayerPage;
import pages.SignInPage;

import static utils.Driver.getDriver;
import static utils.Util.*;

public class CartSteps implements En {
    public CartSteps() {

        LandingPage landingPage = new LandingPage();
        ProductLayerPage productLayerPage = new ProductLayerPage();
        OrderPage orderPage = new OrderPage();
        SignInPage signInPage = new SignInPage();

        Given("^I am on the Landing page$", () -> {
            String landingPageUrl = "http://automationpractice.com/index.php";
            getDriver().get(landingPageUrl);
        });

        When("^I add the t-shirt to cart$", () -> {
            landingPage.addTSirtToCart();
        });

        Then("^I should see successfully message$", () -> {
            waitElement(productLayerPage.getSuccessfulyMessage());
            String expectedMessage = "Product successfully added to your shopping cart";
            String successfullyMessage = productLayerPage.getSuccessfulyMessage().getText();
            Assert.assertEquals(expectedMessage, successfullyMessage);
        });

        And("^I click on Proceed to checkout button$", () -> {
            waitElement(productLayerPage.getSuccessfulyMessage());
            productLayerPage.proceedToCart();
        });

        Then("^I should be redirected to Order page$", () -> {
            String cartUrl = "http://automationpractice.com/index.php?controller=order";
            String currentlyUrl = getDriver().getCurrentUrl();
            Assert.assertEquals(cartUrl, currentlyUrl);
        });

        And("^I should see my added product$", () -> {
            waitElement(orderPage.getFirstProduct());
            Assert.assertTrue(orderPage.getFirstProduct().isDisplayed());

            String productAdded = orderPage.getFirstProduct().getText();
            Assert.assertEquals("Faded Short Sleeve T-shirts", productAdded);
        });

        And("^I click on Shopping cart button$", () -> {
            waitElement(productLayerPage.getSuccessfulyMessage());
            productLayerPage.closeLayer();
            landingPage.goCart();
        });

        Given("^I have one t-shirt in cart$", () -> {
            landingPage.addTSirtToCart();
            waitElement(productLayerPage.getSuccessfulyMessage());
            productLayerPage.closeLayer();
        });

        And("^I am on the Order page$", () -> {
            landingPage.goCart();
        });

        When("^I delete the product$", () -> {
            orderPage.deletItem();
        });

        Then("^I should see the cart empty$", () -> {
            waitElement(orderPage.getMessageEmpty());
            Assert.assertEquals("Your shopping cart is empty.", orderPage.getMessageEmpty().getText());
        });

        When("^I click on minus button$", () -> {
            waitElement(orderPage.getFirstProduct());
            orderPage.decreaseQuantity();
        });

        When("^I type (\\d+) on quantity$", (Integer quantity) -> {
            waitElement(orderPage.getFirstProduct());
            orderPage.typeQuantity(quantity);
        });

        Then("^I should see \"([^\"]*)\" on Total field$", (String expectedPrice) -> {
            waitASecond();
            scrollTo(orderPage.getTotalPrice());
            String price = orderPage.getTotalPrice().getText();

            Assert.assertEquals(expectedPrice, price);
        });

        When("^I click on plus button$", () -> {
            waitElement(orderPage.getFirstProduct());
            orderPage.increaseQuantity();
        });

        And("^I add one more t-shirt$", () -> {
            orderPage.increaseQuantity();
            waitASecond();
        });


        When("^I Proceed to chekcout$", () -> {
            orderPage.proceedToAdress();
        });

        Then("^I should be redirected to Login tab$", () -> {
            String authTab = "controller=authentication";
            wait.until(ExpectedConditions.urlContains(authTab));

            String url = getDriver().getCurrentUrl();
            Assert.assertTrue(url.contains(authTab));
        });

        Given("^I am logged$", () -> {
            getDriver().get("http://automationpractice.com/index.php?controller=authentication");
            signInPage.typeEmail("gustavo@philips.com");
            signInPage.typePass("senha");
            signInPage.signIn();
            signInPage.goHome();
        });

        Then("^I should be redirected to Address tab$", () -> {
            String addressTab = "order&step=1";
            wait.until(ExpectedConditions.urlContains(addressTab));

            String url = getDriver().getCurrentUrl();
            Assert.assertTrue(url.contains(addressTab));
        });

        And("^I proceed to Shipping tab$", () -> {
            orderPage.proceedToAdress();
            orderPage.proceedToShipping();
        });

        Then("^I should see \"([^\"]*)\" alert$", (String expectedMessage) -> {
            waitElement(orderPage.getMessageOfTherms());

            String receivedMessage = orderPage.getMessageOfTherms().getText();
            Assert.assertEquals(expectedMessage, receivedMessage);
        });

        When("^I click on Proceed to Payment whiout check therms$", () -> {
            orderPage.proceedToPayment();
        });

        When("^I click on Proceed to Payment$", () -> {
            orderPage.checkTherms();
            orderPage.proceedToPayment();
        });

        When("^I select pay by bank wire$", () -> {
            orderPage.selectBankWire();
        });

        When("^I select pay by check$", () -> {
            orderPage.selectCheck();
        });

        And("^I confirm my order$", () -> {
            orderPage.confirmOrder();
        });

        Then("^I should see order confirmation by bank wire$", () -> {
            String expectedConfirmation = "Your order on My Store is complete.";
            waitElement(orderPage.getOrderConfirmationByBankWire());

            String confirmation = orderPage.getOrderConfirmationByBankWire().getText();
            Assert.assertEquals(expectedConfirmation, confirmation);
        });

        Then("^I should see order confirmation by check$", () -> {
            String expectedConfirmation = "Your order on My Store is complete.";
            waitElement(orderPage.getOrderConfirmationByCheck());

            String confirmation = orderPage.getOrderConfirmationByCheck().getText();
            Assert.assertEquals(expectedConfirmation, confirmation);
        });

    }
}
