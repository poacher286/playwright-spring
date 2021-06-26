package com.play.playwrightspring.poacher.config;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BrowserChannel;
import com.play.playwrightspring.poacher.annotation.LazyConfiguration;
import com.play.playwrightspring.poacher.annotation.ThreadScopeBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@LazyConfiguration
public class PageConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser",
            havingValue = "firefox")
    public Page firefoxDriver() {
        return Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser",
            havingValue = "safari")
    public Page safariDriver() {
        return Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public Page chromeDriver() {
        // Can be "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
        BrowserContext context = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel(BrowserChannel.CHROME).setHeadless(false)).newContext();
        context.route("**/*.{png,jpg,jpeg,css}", Route::abort);
        return context.newPage();
//        return playwright.chromium()
//                .launch(new BrowserType.LaunchOptions().setChannel(BrowserChannel.CHROME).setHeadless(false))
//                .newPage();
    }

}
