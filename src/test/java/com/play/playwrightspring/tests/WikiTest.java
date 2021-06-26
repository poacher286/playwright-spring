package com.play.playwrightspring.tests;

import com.play.playwrightspring.SpringBaseTestNG;
import com.play.playwrightspring.page.WikiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikiTest extends SpringBaseTestNG {

    @Autowired
    private WikiPage wikiPage;

    @BeforeClass
    public void navigate() {
        wikiPage.navigate();
    }

    @Test
    public void wikiHomeTest() {
        Assert.assertTrue(this.wikiPage.isDisplayed());
    }
}
