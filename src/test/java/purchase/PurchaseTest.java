package purchase;

import conf.BaseTest;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PurchaseTest extends BaseTest {

    @BeforeMethod
    public void setUpPurchaseTest() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("userTest123456", "userTest123456");
        menuPage.clickOnLaptopsButton();

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.selectFirstItem();


        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnAddToCartButton();
        menuPage.clickOnCartButton();
    }

    @Test(description = "Purchase test",  enabled = true)
    public void purchaseTest() throws IOException {



        CartPage cartPage = new CartPage(driver);
        cartPage.placeOrder();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.placeOrderPurchase("UserTest", "Bolivia", "La Paz", "111111111", "10", "2025");

        PurchasePage purchasePage = new PurchasePage(driver);
        Assert.assertTrue(purchasePage.purchaseTextIsDisplayed());
    }
}
