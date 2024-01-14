package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Task2Test {

    @Test
    public void WikiTest() {

        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();

        webDriver.get("https://pl.wikipedia.org/wiki/Wiki");
        webDriver.manage().window().maximize();

        List<WebElement> languagesLinks = webDriver.findElements(By.cssSelector("li[class^='interlanguage-link'] a"));
        int i = languagesLinks.size();
        System.out.println(i);

        for (WebElement languageLink : languagesLinks) {
            String languageText = languageLink.getDomProperty("textContent");
            System.out.println(languageText);
            if (languageText.equals("English")){
                String url = languageLink.getAttribute("href");
                System.out.println(url);
            }
        }
        webDriver.quit();
    }
}
