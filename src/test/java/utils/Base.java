package utils;

import org.openqa.selenium.support.PageFactory;

public class Base {
    public Base() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
