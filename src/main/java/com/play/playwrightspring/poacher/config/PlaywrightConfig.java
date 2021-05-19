package com.play.playwrightspring.poacher.config;

import com.microsoft.playwright.Playwright;
import com.play.playwrightspring.poacher.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class PlaywrightConfig {

    @Bean
    public Playwright getPlaywright(){
        return Playwright.create();
    }
}
