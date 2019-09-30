package steps;

import cucumber.api.java8.En;
import org.junit.Assert;
import pages.AccountPage;
import pages.SignInPage;

import static utils.Driver.getDriver;

public class SignInSteps implements En {
    public SignInSteps() {

        SignInPage signInPage = new SignInPage();
        AccountPage accountPage = new AccountPage();

        //TODO separete informations in data file
        String urlLogin = "http://automationpractice.com/index.php?controller=authentication";
        String validEmail = "gustavo@philips.com";
        String validPass = "senha";

        Given("^I am on the Login page$", () -> {
            getDriver().get(urlLogin);
        });

        When("^I fill valid email and password$", () -> {
            signInPage.typeEmail(validEmail);
            signInPage.typePass(validPass);
        });

        And("^I submit$", () -> {
            signInPage.signIn();
        });

        Then("^I should be redirected to My Account page$", () -> {
            String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
            String received = accountPage.returnWelcome().getText();
            Assert.assertEquals(expected, received);
        });

        When("^I fill valid email$", () -> {
            signInPage.typeEmail(validEmail);
        });

        Then("^I should not be authorized$", () -> {
            String currentUrl = getDriver().getCurrentUrl();
            Assert.assertEquals(urlLogin, currentUrl);
        });

        And("^I should see \"([^\"]*)\" error$", (String message) -> {
            String messageReceived = signInPage.getErrorMessage().getText();
            Assert.assertEquals(message, messageReceived);
        });

        When("^I fill valid password$", () -> {
            signInPage.typePass(validPass);
        });

        And("^I fill wrong password$", () -> {
            signInPage.typePass("EROOOUUU");
        });

        When("^I fill email with \"([^\"]*)\"$", (String email) -> {
            signInPage.typeEmail(email);
        });

    }
}
