package com.gitlab.rmarzec.framework.pages.google;

import com.gitlab.rmarzec.framework.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieWindow extends PageObject {

    @FindBy(xpath = "//button/div[contains(text(), 'Zaakceptuj wszystko')]")
    private WebElement acceptCookiesButton;

    public CookieWindow(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies(){
        acceptCookiesButton.click();
    }
}
