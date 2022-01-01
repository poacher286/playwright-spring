package com.play.playwrightspring.page;

import com.play.playwrightspring.poacher.annotation.UIPage;
import org.springframework.beans.factory.annotation.Value;

@UIPage
public class FLipkartPage extends ShoppingTemplate {


    @Value("${flipkart.xboxx.url}")
    private String xboxXUrl;

    private String flipkartTitle = "[title=Flipkart]";
    private String notifyMe = "//button[text()='NOTIFY ME']";
    private String buyNow = "//button[text()='BUY NOW']";

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
        return page.isVisible(buyNow);
    }

    @Override
    public boolean isDisplayed() {
        return page.isVisible(flipkartTitle);
    }
}
