package com.gitlab.rmarzec.framework.pages.w3schools;

import com.gitlab.rmarzec.framework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TryItEditor extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement header;

    public TryItEditor(WebDriver driver) {
        super(driver);
    }

    public void getAndDisplayHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("iframeResult")));
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        String headerText = header.getText();
        System.out.println("Wyświetlam header: " + " " + headerText);
    }

    public void selectOptionAndGetText(String optionText) {
        WebElement option = driver.findElement(By.xpath(String.format("//select[@id='cars']/option[contains(text(),'%s')]", optionText)));
        option.click();
        String value = option.getAttribute("value");
        String text = option.getText();
        System.out.println("Pobieram tekst i wartość selecta: "+ " " + text + " " + value);
    }
}
