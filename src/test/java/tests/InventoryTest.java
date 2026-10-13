package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DataDriven;

public class InventoryTest extends BaseTest {

    private InventoryPage inventoryPage;


    @BeforeMethod(dependsOnMethods = "setUp")
    public void loginFirst() {
        JsonNode valid = DataDriven.jsonReader().get("validUser");

        new LoginPage(driver).login(
                valid.get("username").asText(),
                valid.get("password").asText());

        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void verifyInventoryPageElements() {
        Assert.assertEquals(inventoryPage.getPageTitle(), "Swag Labs",
                "Page title is not 'Swag Labs'!");

        Assert.assertTrue(inventoryPage.isCartIconDisplayed(),
                "Cart icon is NOT displayed!");

        Assert.assertEquals(inventoryPage.getProductsCount(), 6,
                "Expected 6 products on the Inventory page!");
    }
}
