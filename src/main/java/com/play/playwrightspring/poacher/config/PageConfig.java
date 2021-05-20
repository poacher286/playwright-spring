package com.play.playwrightspring.poacher.config;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BrowserChannel;
import com.play.playwrightspring.poacher.annotation.LazyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class PageConfig {

    @Autowired
    private Playwright playwright;

    @Bean
    @ConditionalOnProperty(name = "browser",
            havingValue = "firefox")
    public Page firefoxDriver() {
        return playwright.firefox()
                .launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newPage();
    }

    @Bean
    @ConditionalOnProperty(name = "browser",
            havingValue = "safari")
    public Page safariDriver() {
        return playwright.webkit()
                .launch(new BrowserType.LaunchOptions().setHeadless(false))
                .newPage();
    }

    @Bean
    @ConditionalOnMissingBean
    public Page chromeDriver() {
        // Can be "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
        return playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setChannel(BrowserChannel.CHROME).setHeadless(false))
                .newPage();
    }

}
