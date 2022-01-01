package com.play.playwrightspring.page;

import com.play.playwrightspring.poacher.annotation.UIPage;
import org.springframework.beans.factory.annotation.Value;

@UIPage
public class AmazonPage extends ShoppingTemplate {

    @Value("${amazon.xboxx.url}")
    private String xboxXUrl;

    private String amazonTitle = "//a[@href='/ref=nav_logo']";
    private String notifyMe = "//*[@id='availability']//span[contains(text(),'unavailable')]";

    @Override
    public void navigate() {
        page.navigate(xboxXUrl);
        page.setDefaultTimeout(0);
    }

    @Override
    public boolean notifyMe() {
        return page.isVisible(notifyMe);
    }

    @Override
    public boolean buyNow() {
        return !page.isVisible(notifyMe);
    }

    @Override
    public boolean isDisplayed() {
        return page.isVisible(amazonTitle);
    }
}
