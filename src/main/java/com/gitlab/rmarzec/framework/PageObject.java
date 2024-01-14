package com.gitlab.rmarzec.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected final WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
