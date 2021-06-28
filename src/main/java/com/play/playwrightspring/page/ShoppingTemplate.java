package com.play.playwrightspring.page;

import com.play.playwrightspring.poacher.utils.SoundUtil;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ShoppingTemplate extends AbstractBasePage {

    @Value("${durationToCheck}")
    private int duration;

    public abstract void navigate();

    public abstract boolean notifyMe();

    public void checkAvailability() throws Exception {
        this.navigate();
        this.isDisplayed();
        for (int i = 0; i < duration; i++) {
            if (!this.notifyMe()) {
                SoundUtil.tone(1000, 100, 1.0);
                System.err.println("In Stock : " + this.getClass().getSimpleName() + " : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " :: " + !this.notifyMe());
            }
            System.out.println("Out of Stock : " + this.getClass().getSimpleName() + " : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " :: " + this.notifyMe());
            page.reload();
            this.isDisplayed();
        }
    }
}
