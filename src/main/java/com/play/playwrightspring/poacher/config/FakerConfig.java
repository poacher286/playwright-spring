package com.play.playwrightspring.poacher.config;

import com.github.javafaker.Faker;
import com.play.playwrightspring.poacher.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
