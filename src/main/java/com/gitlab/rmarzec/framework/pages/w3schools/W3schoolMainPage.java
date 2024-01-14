package com.gitlab.rmarzec.framework.pages.w3schools;

import com.gitlab.rmarzec.framework.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class W3schoolMainPage extends PageObject {

    @FindBy(xpath = "//a[@class='w3-btn w3-margin-bottom'][contains(text(), 'Try it Yourself »')]")
    private List<WebElement> tryItButtons;

    public W3schoolMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickTryItYourselfButton(){
        tryItButtons.get(0).click();
        String currentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
