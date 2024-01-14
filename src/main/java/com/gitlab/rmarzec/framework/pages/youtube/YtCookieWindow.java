package com.gitlab.rmarzec.framework.pages.youtube;

import com.gitlab.rmarzec.framework.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YtCookieWindow extends PageObject {

    @FindBy(xpath = "//button[@aria-label='Zaakceptuj wykorzystywanie plików cookie i innych danych do opisanych celów']")
    private WebElement acceptCookiesYtButton;

    public YtCookieWindow(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiesYoutube(){
        acceptCookiesYtButton.click();
    }
}

