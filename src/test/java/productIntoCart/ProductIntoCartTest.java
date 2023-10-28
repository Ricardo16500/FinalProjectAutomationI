package productIntoCart;

import conf.BaseTest;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductIntoCartTest extends BaseTest {
    private final String expectedName = "Sony vaio i5";
    private final String expectedPrice = "790";

    @BeforeMethod
    public void setUpProductIntoCart() throws IOException{
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

    @Test(description="Select product and see the description into cartPage", enabled=true)
    public void productIntoCartTest() throws IOException {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getFirstItemName(),expectedName);
        Assert.assertEquals(cartPage.getPrice(),expectedPrice);
    }
    @AfterMethod
    public void afterProductIntoCart(){
        CartPage cartPage = new CartPage(driver);
        cartPage.removeAllItems();
    }

}
