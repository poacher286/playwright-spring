package com.play.playwrightspring.page;

import com.play.playwrightspring.poacher.annotation.UIPage;
import org.springframework.beans.factory.annotation.Value;

@UIPage
public class WikiPage extends AbstractBasePage {

    @Value("${wiki.url}")
    private String wikiUrl;

    private final String slogan = "//*[contains(@class,'slogan')]";


    public void navigate() {
        page.navigate(wikiUrl);
    }

    @Override
    public boolean isDisplayed() {
        return page.isVisible(slogan);
    }
}
