package org.example.pages;

import com.aventstack.extentreports.Status;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private By laptopName = By.xpath("//h2[contains(text(),\"Sony vaio i5\")]");
    private By laptopPrice = By.xpath("//h3[contains(text(),\"790\")]");


    public void clickOnAddToCartButton() throws IOException {
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        alert.accept();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Add item to cart");
    }
    public boolean laptopNameIsDisplayed(){
        return driver.findElement(laptopName).isDisplayed();
    }
    public boolean laptopPriceIsDisplayed(){
        return driver.findElement(laptopPrice).isDisplayed();
    }

}
