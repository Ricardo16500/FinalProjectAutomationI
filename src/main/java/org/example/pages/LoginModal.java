package org.example.pages;

import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class LoginModal extends BasePage {

    private By usernameTxt = By.id("loginusername");

    private By passwordTxt = By.id("loginpassword");

    private By logInBtn = By.xpath("//button[contains(text(),'Log in')]");

    @Getter
    private String alertText;


    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String username) {
        driver.findElement(usernameTxt).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void clickOnLogInBtn() {
        driver.findElement(logInBtn).click();
    }


    public void loginWithCredentials(String username, String password) throws IOException {
        fillUsername(username);
        fillPassword(password);
        clickOnLogInBtn();

        try {

            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            System.out.println("Texto del alerta: " + alertText);

            alert.accept();
            driver.switchTo().defaultContent();
        } catch (NoAlertPresentException e) {
            System.out.println("No se detectó un alerta en la página.");
        } catch (TimeoutException e) {
            System.out.println("No se detectó un alerta en la página");
        }

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Login");
    }

}
