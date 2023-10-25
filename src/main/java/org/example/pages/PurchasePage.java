package org.example.pages;

import com.aventstack.extentreports.Status;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class PurchasePage extends BasePage{
    public PurchasePage(WebDriver driver) {
        super(driver);
    }
    private By purchaseText = By.xpath("//h2[contains(text(),\"Thank you for your purchase!\")]");
    private By purchaseData = By.xpath("  //p[contains(@class, 'lead') and contains(@class, 'text-muted')]");
    private By purchaseOk = By.xpath("//button[contains(text(),\"OK\")]");

    public boolean purchaseTextIsDisplayed() throws IOException {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Complete purchase");
        return driver.findElement(purchaseText).isDisplayed();
    }
    public String[] getOrderValues(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(purchaseData));
        String[] orderValues = driver.findElement(purchaseData).getText().split("\n");
        String user = "";
        String amount = "";

        for (String values: orderValues){
            if (values.contains("Name:")){
                user = values.replace("Name: ", "").trim();
            } else if (values.contains("Amount:")) {
                amount = values.replace("Amount: ", "").trim();
            }
        }
        String [] values ={user, amount};

        return values;
    }
    public void clickOnOk(){
        driver.findElement(purchaseOk).click();
    }
}
