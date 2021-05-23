package com.play.playwrightspring.page;

import com.microsoft.playwright.Page;
import com.play.playwrightspring.poacher.annotation.UIPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@UIPage
public class FLipkartPage extends AbstractBasePage {

    @Autowired
    private Page page;

    @Value("${flipkart.xboxx.url}")
    private String xboxXUrl;

    private String flipkartTitle = "[title=Flipkart]";
    private String notifyMe = "//button[text()='NOTIFY ME']";
    private String buyNow = "//button[text()='BUY NOW']";

    public void navigate() {
        page.navigate(xboxXUrl);
        page.setDefaultTimeout(0);
    }

    public boolean notifyMe(){
        return page.isVisible(notifyMe);
    }

    public boolean buyNow(){
        return page.isVisible(buyNow);
    }

    @Override
    public boolean isDisplayed() {
        return page.isVisible(flipkartTitle);
    }
}
