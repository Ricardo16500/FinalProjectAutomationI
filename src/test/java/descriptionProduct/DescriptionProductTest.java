package descriptionProduct;

import conf.BaseTest;
import jdk.jfr.Description;
import org.example.pages.LaptopsPage;
import org.example.pages.LoginPage;
import org.example.pages.MenuPage;
import org.example.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DescriptionProductTest extends BaseTest {

    @BeforeMethod
    public void setUpDescriptionProductTest() throws IOException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickOnLogInBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("userTest123456", "userTest123456");
        menuPage.clickOnLaptopsButton();

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.selectFirstItem();
    }

    @Test(description = "View description about product", enabled = true)
    public void descriptionProductTest(){
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.laptopNameIsDisplayed());
        Assert.assertTrue(productPage.laptopPriceIsDisplayed());
    }

}
