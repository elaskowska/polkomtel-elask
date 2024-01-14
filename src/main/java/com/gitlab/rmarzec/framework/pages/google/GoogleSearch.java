package com.gitlab.rmarzec.framework.pages.google;

import com.gitlab.rmarzec.framework.PageObject;
import com.gitlab.rmarzec.framework.utils.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch extends PageObject {

    @FindBy(xpath = "//textarea[@aria-label='Szukaj']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@aria-label='Szczęśliwy traf']")
    private WebElement luckyButton;

    public GoogleSearch(WebDriver driver) {
        super(driver);
    }

    public void searchAndClickLuckyButton(String searchingText){
        SeleniumActions.wait(driver, searchInput);
        searchInput.sendKeys(searchingText);
        SeleniumActions.waitForClickable(driver, luckyButton);
        luckyButton.click();
    }
}
