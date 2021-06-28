package com.play.playwrightspring.tests;

import com.play.playwrightspring.SpringBaseTestNG;
import com.play.playwrightspring.page.AmazonPage;
import com.play.playwrightspring.page.FLipkartPage;
import com.play.playwrightspring.page.ShoppingTemplate;
import com.play.playwrightspring.poacher.annotation.LazyAutowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NotifyStock extends SpringBaseTestNG {

    @LazyAutowired
    private FLipkartPage fLipkartPage;
    @LazyAutowired
    private AmazonPage amazonPage;

    @Test(dataProvider = "getPage")
    public void checkStock(ShoppingTemplate shoppingTemplate) throws Exception {
        shoppingTemplate.checkAvailability();
    }

    @DataProvider(parallel = true)
    public Object[] getPage() {
        return new Object[]{
                fLipkartPage,
                amazonPage
        };
    }

}
