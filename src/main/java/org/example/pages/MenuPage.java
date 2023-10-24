package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage {

    private static final Logger log = LogManager.getLogger(MenuPage.class);

    private By HomeButton = By.id("nava");
    private By logInBtn = By.id("login2");
    private By logOutBtn = By.id("logout2");
    private By CartButton = By.id("cartur");
    private By laptopsButton = By.xpath("//a[contains(text(),'Laptops')]");


    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogInBtn() {
        driver.findElement(logInBtn).click();
    }

    public void clickOnLogOutBtn() {
        driver.findElement(logOutBtn).click();
    }

    public void clickOnCartButton() { driver.findElement(CartButton).click(); }

    public void clickOnHomeButton() { driver.findElement(HomeButton).click();}

    public boolean logOutBtnIsDisplayed() {
        //TODO - Verificar que la espera es necesaria en esta parte, tomando en cuenta que ya existe una espera
        //       explicita para esperar la alerta

        log.info("Log out button is displayed before wait: " + driver.findElement(logOutBtn).isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutBtn));
        log.info("Log out button is displayed after wait: " + driver.findElement(logOutBtn).isDisplayed());

        return driver.findElement(logOutBtn).isDisplayed();
    }

    public void clickOnLaptopsButton() {
        driver.findElement(laptopsButton).click();
    }


}
