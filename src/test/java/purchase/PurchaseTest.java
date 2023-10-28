package purchase;

import conf.BaseTest;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PurchaseTest extends BaseTest {
    String expectedUser = "UserTest";
    String expectedAmount = "790";

    @BeforeMethod
    public void setUpPurchaseTest() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials(getUser(), getPassword());
        menuPage.clickOnLaptopsButton();

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.selectFirstItem();


        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnAddToCartButton();
        menuPage.clickOnCartButton();
    }

    @Test(description = "Purchase test", enabled = true)
    public void purchaseTest() throws IOException {
        CartPage cartPage = new CartPage(driver);
        cartPage.placeOrder();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.placeOrderPurchase(expectedUser, "Bolivia", "La Paz", "111111111", "10", "2025");

        PurchasePage purchasePage = new PurchasePage(driver);
        Assert.assertTrue(purchasePage.purchaseTextIsDisplayed());
        Assert.assertEquals(purchasePage.getOrderValues()[1], expectedAmount + " USD");
        Assert.assertEquals(purchasePage.getOrderValues()[0], expectedUser);

    }

    @AfterMethod
    public void afterPurchaseTest() {
        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.clickOnOk();
    }
}
