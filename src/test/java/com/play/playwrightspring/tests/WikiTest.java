package com.play.playwrightspring.tests;

import com.play.playwrightspring.SpringBaseTestNG;
import com.play.playwrightspring.page.WikiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class WikiTest extends SpringBaseTestNG {

    @Autowired
    private WikiPage wikiPage;

    @Test
    public void wikiHomeTest(){

    }
}
