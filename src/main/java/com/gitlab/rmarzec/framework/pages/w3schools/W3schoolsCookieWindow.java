package com.gitlab.rmarzec.framework.pages.w3schools;

import com.gitlab.rmarzec.framework.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class W3schoolsCookieWindow extends PageObject {

    @FindBy(xpath = "//div[@class='sn-b-def  sn-blue'][contains(text(), 'Zaakceptuj wszystko i odwiedź witrynę')]")
    private WebElement acceptCookiesW3Button;

    public W3schoolsCookieWindow(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiesW3(){
        acceptCookiesW3Button.click();
    }
}
