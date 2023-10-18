package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage {

    private static final Logger log = LogManager.getLogger(MenuPage.class);
    private By logInBtn = By.id("login2");
    private By logOutBtn = By.id("logout2");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogInBtn() {
        driver.findElement(logInBtn).click();
    }

    public void clickOnLogOutBtn() {
        driver.findElement(logOutBtn).click();
    }

    public boolean logOutBtnIsDisplayed() {
        log.info("Log out button is displayed before wait: " + driver.findElement(logOutBtn).isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutBtn));

        log.info("Log out button is displayed after wait: " + driver.findElement(logOutBtn).isDisplayed());

        return driver.findElement(logOutBtn).isDisplayed();
    }



}
