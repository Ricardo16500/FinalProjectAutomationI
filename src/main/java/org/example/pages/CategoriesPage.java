package org.example.pages;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CategoriesPage extends BasePage {

    private static final Logger log = LogManager.getLogger(MenuPage.class);
    private By phoneButton = By.xpath("//a[contains(text(),'Phones')]");
    private By laptopsButton = By.xpath("//a[contains(text(),'Laptops')]");
    private By monitorsButton = By.xpath("//a[contains(text(),'Monitors')]");


    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPhoneButton() {
        driver.findElement(phoneButton).click();
    }

    public void clickOnLaptopsButton() throws IOException {
        driver.findElement(laptopsButton).click();

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Click on laptops button");
    }

    public void clickOnMonitorsButton() {
        driver.findElement(monitorsButton).click();
    }




}
