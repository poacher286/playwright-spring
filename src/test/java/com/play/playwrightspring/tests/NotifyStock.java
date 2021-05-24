package com.play.playwrightspring.tests;

import com.microsoft.playwright.Page;
import com.play.playwrightspring.SpringBaseTestNG;
import com.play.playwrightspring.page.FLipkartPage;
import com.play.playwrightspring.poacher.utils.SoundUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sound.sampled.LineUnavailableException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotifyStock extends SpringBaseTestNG {

    @Autowired
    private FLipkartPage fLipkartPage;

    @Autowired
    private Page page;

    @BeforeClass
    public void navigate(){
        fLipkartPage.navigate();
        fLipkartPage.isDisplayed();
    }

    @Test
    public void checkStock() throws LineUnavailableException {
        for (int i=0; i<1000; i++){
            if (!fLipkartPage.notifyMe()){
                SoundUtil.tone(1000,100, 1.0);
                System.err.println("In Stock : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " :: " +!fLipkartPage.notifyMe());
            }
            System.out.println("Out of Stock : "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " :: " +fLipkartPage.notifyMe());
            page.reload();
            fLipkartPage.isDisplayed();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
