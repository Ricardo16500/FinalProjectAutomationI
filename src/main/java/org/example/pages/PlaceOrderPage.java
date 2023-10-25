package org.example.pages;

import com.aventstack.extentreports.Status;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

// //h2[contains(text(),"Thank you for your purchase!")]
// //button[contains(text(),"OK")]
public class PlaceOrderPage extends BasePage{
    private By name = By.id("name");
    private By country = By.id("country");
    private By city = By.id("city");
    private By card = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");

    private By btnPurchase = By.xpath("//button[contains(text(),'Purchase')]");

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }
    public void fillName(String name){
        driver.findElement(this.name).sendKeys(name);
    }
    public void fillCountry(String country){
        driver.findElement(this.country).sendKeys(country);
    }
    public void fillCity(String city){
        driver.findElement(this.city).sendKeys(city);
    }
    public void fillCard(String card){
        driver.findElement(this.card).sendKeys(card);
    }
    public void fillMonth(String month){
        driver.findElement(this.month).sendKeys(month);
    }
    public void fillYear(String year){
        driver.findElement(this.year).sendKeys(year);
    }
    public void clickOnPurchase(){
        driver.findElement(btnPurchase).click();
    }
    public void placeOrderPurchase(String name, String country, String city, String card, String month, String year) throws IOException {
        fillName(name);
        fillCountry(country);
        fillCity(city);
        fillCard(card);
        fillMonth(month);
        fillYear(year);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Fill data to purchase");
        clickOnPurchase();

    }

}
