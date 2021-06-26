package com.play.playwrightspring.tests;

import com.microsoft.playwright.Page;
import com.play.playwrightspring.SpringBaseTestNG;
import com.play.playwrightspring.page.AmazonPage;
import com.play.playwrightspring.page.FLipkartPage;
import com.play.playwrightspring.page.ShoppingTemplate;
import com.play.playwrightspring.poacher.annotation.LazyAutowired;
import com.play.playwrightspring.poacher.utils.SoundUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.sound.sampled.LineUnavailableException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotifyStock extends SpringBaseTestNG {

    @LazyAutowired
    private FLipkartPage fLipkartPage;
    @LazyAutowired
    private AmazonPage amazonPage;

    @LazyAutowired
    private Page page;

    @Test(dataProvider = "getPage")
    public void checkStock(ShoppingTemplate shoppingTemplate) throws LineUnavailableException {
        shoppingTemplate.navigate();
        shoppingTemplate.isDisplayed();
        for (int i = 0; i < 3600; i++) {
            if (!shoppingTemplate.notifyMe()) {
                SoundUtil.tone(1000, 100, 1.0);
                System.err.println("In Stock : " + shoppingTemplate.getClass().getSimpleName() + " : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " :: " + !shoppingTemplate.notifyMe());
            }
            System.out.println("Out of Stock : " + shoppingTemplate.getClass().getSimpleName() + " : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " :: " + shoppingTemplate.notifyMe());
            page.reload();
            shoppingTemplate.isDisplayed();
        }
    }

    @DataProvider(parallel = true)
    public Object[] getPage() {
        return new Object[]{
                fLipkartPage,
                amazonPage
        };
    }

}
