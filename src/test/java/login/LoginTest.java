package login;

import com.aventstack.extentreports.Status;
import conf.BaseTest;
import org.example.helpers.ScreenShotHelper;
import org.example.pages.LoginPage;
import org.example.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {
    /**
     * Valid credentials
     * user: userTest123456
     * password: userTest123456
     */
    @Test(description = "Login with valid credentials")
    public void loginCorrect() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("userTest123456", "userTest123456");

        Assert.assertTrue(menuPage.logOutBtnIsDisplayed());
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Login correct");

    }

    @Test(description = "Login with null credentials")
    public void loginIncorrectNull() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("", "");

        Assert.assertEquals(loginPage.getAlertText(), "Please fill out Username and Password.");

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Alert at login");
    }

    @Test(description = "Login with null user")
    public void loginIncorrectNullUser() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("", "userTest123456");

        Assert.assertEquals(loginPage.getAlertText(), "Please fill out Username and Password.");

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Alert at login");
    }
//
    @Test(description = "Login with null password")
    public void loginIncorrectNullPassword() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("userTest123456", "");

        Assert.assertEquals(loginPage.getAlertText(), "Please fill out Username and Password.");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Alert at login");


    }
//
    @Test(description = "Login with user that does not exist")
    public void loginIncorrectUser() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("user@#test%^12345", "userTest123456");

        Assert.assertEquals(loginPage.getAlertText(), "User does not exist.");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Alert at login");
    }

    @Test(description = "Login with bad password")
    public void loginIncorrectPassword() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("userTest123456", "user@#test%^12345");


        Assert.assertEquals(loginPage.getAlertText(), "Wrong password.");
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Alert at login");
    }
//
}
