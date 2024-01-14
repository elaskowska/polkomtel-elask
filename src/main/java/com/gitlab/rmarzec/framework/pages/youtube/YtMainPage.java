package com.gitlab.rmarzec.framework.pages.youtube;

import com.gitlab.rmarzec.framework.PageObject;
import com.gitlab.rmarzec.framework.model.YTTile;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class YtMainPage extends PageObject {

    @FindBy(tagName = "ytd-rich-grid-media")
    private List<WebElement> videos;

    public YtMainPage(WebDriver driver) {
        super(driver);
    }

    public List<YTTile> getTiles() {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("ytd-rich-grid-media")));
        List<YTTile> tiles = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            WebElement video = videos.get(i);
            String title = video.findElement(By.cssSelector("a#video-title-link")).getAttribute("title");
            String channelName = video.findElement(By.cssSelector("ytd-channel-name yt-formatted-string")).getAttribute("title");

            String length = video.findElement(By.cssSelector("yt-formatted-string#length")).getAttribute("aria-label");
            try {
                if (!video.findElements(By.xpath(".//p[@class='style-scope ytd-badge-supported-renderer'][contains(text(), 'NA ŻYWO')]")).isEmpty()) {
                    length = "live";
                }
            } catch (NoSuchElementException ignore) {
            }

            tiles.add(new YTTile(title, channelName, length));
        }

        return tiles;
    }
}
