package org.example.pages;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class CartPage extends BasePage {

    private static final Logger log = LogManager.getLogger(LaptopsPage.class);

    private final By firstItemName = By.xpath("//tbody/tr/td[2]");

    private final By tableLocator = By.cssSelector("div.table-responsive table.table");

    private final By itemLocator = By.cssSelector("table.table tbody#tbodyid tr.success");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstItemName() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemName));
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Get first item name");
        return driver.findElement(firstItemName).getText();
    }

    public void removeAllItems() {
        //TODO: AVC Funciona AVC No funciona
        log.info("Removing all items from the cart");

        while(areThereAnyItemsInTheCart()){
            WebElement table = driver.findElement(tableLocator);
            List<WebElement> items = table.findElements(itemLocator);

            log.info("Items in the cart: " + items.size());

            for (WebElement item : items) {
                item.findElement(By.xpath("//td[4]/a")).click();
            }
        }


    }

    public boolean areThereAnyItemsInTheCart() {
        //TODO: Mejorar la logica de este metodo

        log.info("Checking if there are any items in the cart");

        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);

            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(tableLocator),
                    ExpectedConditions.presenceOfElementLocated(itemLocator)
            ));

            WebElement table = driver.findElement(tableLocator);

            log.info("Are there any items in the cart? " + !table.findElements(itemLocator).isEmpty());
            return !table.findElements(itemLocator).isEmpty();
        } catch (Exception e) {
            log.error("No items in the cart: " + e);
        }
        log.info("Are there any items in the cart? " + false + " (Exception)");

        return false;
    }

}