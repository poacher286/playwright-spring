package com.play.playwrightspring.page;

import com.microsoft.playwright.Page;
import com.play.playwrightspring.poacher.annotation.LazyAutowired;

public abstract class AbstractBasePage {

    @LazyAutowired
    protected Page page;

    public abstract boolean isDisplayed();

}
