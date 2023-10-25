package org.example.pages;

import com.aventstack.extentreports.Status;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PurchasePage extends BasePage{
    public PurchasePage(WebDriver driver) {
        super(driver);
    }
    private By purchaseText = By.xpath("//h2[contains(text(),\"Thank you for your purchase!\")]");

    public boolean purchaseTextIsDisplayed() throws IOException {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Complete purchase");
        return driver.findElement(purchaseText).isDisplayed();
    }

}
