package com.play.playwrightspring.poacher.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BrowserChannel;
import com.play.playwrightspring.poacher.annotation.LazyConfiguration;
import com.play.playwrightspring.poacher.annotation.ThreadScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@LazyConfiguration
public class BrowserConfig {

    @Autowired
    private Playwright playwright;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public Browser firefoxDriver(){
        return playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public Browser chromeDriver(){
        BrowserType chromium = playwright.chromium();
        // Can be "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
        return chromium.launch(new BrowserType.LaunchOptions().setChannel(BrowserChannel.CHROME).setHeadless(false));
    }
}
