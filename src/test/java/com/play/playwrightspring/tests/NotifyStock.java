package com.play.playwrightspring.tests;

import com.microsoft.playwright.Page;
import com.play.playwrightspring.SpringBaseTestNG;
import com.play.playwrightspring.page.FLipkartPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.swing.*;
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
    @Ignore
    public void checkStock(){
        for (int i=0; i<3600; i++){
            if (fLipkartPage.buyNow()){
                JOptionPane.showMessageDialog(null, "Available ",null, JOptionPane.INFORMATION_MESSAGE);
                System.err.println("In Stock : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " :: " +fLipkartPage.buyNow());
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
