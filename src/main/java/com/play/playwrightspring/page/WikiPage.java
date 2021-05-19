package com.play.playwrightspring.page;

import com.play.playwrightspring.poacher.annotation.Page;

@Page
public class WikiPage extends AbstractBasePage {


    @Override
    protected boolean isDisplayed() {
        return true;
    }
}
