package com.play.playwrightspring.page;

import com.microsoft.playwright.Page;
import com.play.playwrightspring.poacher.annotation.UIPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@UIPage
public class WikiPage extends AbstractBasePage {

    @Autowired
    private Page page;

    @Value("${wiki.url}")
    private String wikiUrl;


    public void navigate(){
        page.navigate(wikiUrl);
    }

    @Override
    protected boolean isDisplayed() {
        return true;
    }
}
