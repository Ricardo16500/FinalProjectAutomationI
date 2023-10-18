package login;

import com.aventstack.extentreports.Status;
import conf.BaseTest;
import org.example.helpers.ScreenShotHelper;
import org.example.pages.LoginModal;
import org.example.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test(description = "Login with valid credentials")
    public void loginCorrect() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "a");

        Assert.assertTrue(menuPage.logOutBtnIsDisplayed());

    }

    @Test(description = "Login with null credentials")
    public void loginIncorrectNull() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("", "");

        Assert.assertEquals(loginModal.getAlertText(), "Please fill out Username and Password.");

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Alert at login");
    }

    @Test(description = "Login with null user")
    public void loginIncorrectNullUser() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("", "a");

        Assert.assertEquals(loginModal.getAlertText(), "Please fill out Username and Password.");

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Alert at login");
    }
//
    @Test(description = "Login with null password")
    public void loginIncorrectNullPassword() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "");

        Assert.assertEquals(loginModal.getAlertText(), "Please fill out Username and Password.");


    }
//
    @Test(description = "Login with user that does not exist")
    public void loginIncorrectUser() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("aiogdauiwvduioa", "a");

        Assert.assertEquals(loginModal.getAlertText(), "User does not exist.");

    }

    @Test(description = "Login with bad password")
    public void loginIncorrectPassword() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "aiogdauiwvduioa");


        Assert.assertEquals(loginModal.getAlertText(), "Wrong password.");
    }
//
}
