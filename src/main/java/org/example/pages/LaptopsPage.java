package org.example.pages;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class LaptopsPage extends BasePage {

    private static final Logger log = LogManager.getLogger(LaptopsPage.class);

    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstItemName() {
//
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.xpath("//h4/a"), "Sony vaio i5"));
        return driver.findElement(By.xpath("//h4/a")).getText();
    }

    public void selectFirstItem() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.xpath("//h4/a"), "Sony vaio i5"));
        log.info("Clicking on first item:" + driver.findElement(By.xpath("//h4/a")).getText());
        driver.findElement(By.xpath("//h4/a")).click();

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Select first item");
    }
}
