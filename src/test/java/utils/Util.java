package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Driver.getDriver;

public class Util extends Base {

    public static WebDriverWait wait = new WebDriverWait(getDriver(), 15);

    public static void waitASecond() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
