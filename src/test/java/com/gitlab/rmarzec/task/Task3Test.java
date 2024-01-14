package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.pages.google.CookieWindow;
import com.gitlab.rmarzec.framework.pages.google.GoogleSearch;
import com.gitlab.rmarzec.framework.pages.w3schools.TryItEditor;
import com.gitlab.rmarzec.framework.pages.w3schools.W3schoolMainPage;
import com.gitlab.rmarzec.framework.pages.w3schools.W3schoolsCookieWindow;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Task3Test {

    @Test
    public void GoogleAndW3SchoolTest() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();

        webDriver.get("https://www.google.com/");
        webDriver.manage().window().maximize();

        CookieWindow form = new CookieWindow(webDriver);
        form.acceptCookies();

        GoogleSearch googleSearch = new GoogleSearch(webDriver);
        googleSearch.searchAndClickLuckyButton("HTML select tag - W3Schools");

        W3schoolsCookieWindow w3schoolsCookieWindow = new W3schoolsCookieWindow(webDriver);
        w3schoolsCookieWindow.acceptCookiesW3();

        String currentUrl = webDriver.getCurrentUrl();

        if (currentUrl.equals("https://www.w3schools.com/tags/tag_select.asp")) {
            System.out.println("Adres właściwej strony: " + currentUrl);

        } else {
            System.out.println(currentUrl);
            webDriver.get("https://www.w3schools.com/tags/tag_select.asp");

        }
        W3schoolMainPage w3schoolMainPage = new W3schoolMainPage(webDriver);
        w3schoolMainPage.clickTryItYourselfButton();

        TryItEditor tryItEditor = new TryItEditor(webDriver);
        tryItEditor.getAndDisplayHeader();
        tryItEditor.selectOptionAndGetText("Opel");

        webDriver.quit();
    }
}
