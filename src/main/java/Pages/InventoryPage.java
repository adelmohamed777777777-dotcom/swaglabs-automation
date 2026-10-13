package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private final WebDriver driver;

    // ---------- Locators ----------
    private final By cartIcon       = By.id("shopping_cart_container");
    private final By inventoryItems = By.className("inventory_item");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- Getters ----------
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isCartIconDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductsCount() {
        return driver.findElements(inventoryItems).size();
    }
}
