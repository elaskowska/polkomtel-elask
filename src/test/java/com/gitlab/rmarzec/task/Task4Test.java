package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.model.YTTile;
import com.gitlab.rmarzec.framework.pages.youtube.YtCookieWindow;
import com.gitlab.rmarzec.framework.pages.youtube.YtMainPage;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;


public class Task4Test {

    @Test
    public void YoutubeTest() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();

        List<YTTile> ytTileList;

        webDriver.get("https://www.youtube.com/");
        webDriver.manage().window().maximize();

        YtCookieWindow ytCookieWindow = new YtCookieWindow(webDriver);
        ytCookieWindow.acceptCookiesYoutube();

        YtMainPage mainPage = new YtMainPage(webDriver);
        ytTileList = mainPage.getTiles();

        ytTileList.stream()
                .filter(tile -> !tile.getLength().equals("live"))
                .forEach(System.out::println);

        webDriver.quit();
    }
}
