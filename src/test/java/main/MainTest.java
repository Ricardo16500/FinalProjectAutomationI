package main;

import conf.BaseTest;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTest extends BaseTest {


    @Test(description = "Login with valid credentials", enabled = false)
    public void loginCorrect() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "a");

        Assert.assertTrue(menuPage.logOutBtnIsDisplayed());
    }

    @Test(description = "Move to Laptops Area", enabled = false)
    public void moveToLaptopsArea() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "a");

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickOnLaptopsButton();

        LaptopsPage laptopsPage = new LaptopsPage(driver);

        Assert.assertEquals(laptopsPage.getFirstItemName(), "Sony vaio i5");
    }

    @Test(description = "Select item and add to cart", enabled = true, priority = 1)
    public void selectItemAndAddToCart() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "a");

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickOnLaptopsButton();

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.selectFirstItem();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnAddToCartButton();

        menuPage.clickOnCartButton();
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getFirstItemName(), "Sony vaio i5");

    }

    @Test(description = "Remove all items from cart", enabled = true)
    public void removeAllItemsFromCart() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "a");

        menuPage.clickOnCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeAllItems();

        Assert.assertFalse(cartPage.areThereAnyItemsInTheCart());

    }

    @Test(description = "Remove all items before select item and add to cart", enabled = true)
    public void removeAllItemsSelectItemAndAddToCart() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginModal loginModal = new LoginModal(driver);
        loginModal.loginWithCredentials("a", "a");

        menuPage.clickOnCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeAllItems();

        menuPage.clickOnHomeButton();

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickOnLaptopsButton();

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.selectFirstItem();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnAddToCartButton();

        menuPage.clickOnCartButton();

        Assert.assertEquals(cartPage.getFirstItemName(), "Sony vaio i5");

    }


}
