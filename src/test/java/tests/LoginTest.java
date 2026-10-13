package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataDriven;

public class LoginTest extends BaseTest {

    private JsonNode data() {
        return DataDriven.jsonReader();
    }

    @Test(priority = 1)
    public void verifySuccessfulLogin() {
        JsonNode valid = data().get("validUser");

        new LoginPage(driver).login(
                valid.get("username").asText(),
                valid.get("password").asText());

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
                "User was NOT redirected to the Inventory page!");
    }

    @Test(priority = 2)
    public void verifyInvalidLogin() {
        JsonNode invalid = data().get("invalidUser");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                invalid.get("username").asText(),
                invalid.get("password").asText());

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username and password do not match"),
                "Expected error message about non-matching credentials was not shown!");
    }

    @Test(priority = 3)
    public void verifyLoginWithoutPassword() {
        JsonNode missing = data().get("userWithoutPassword");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                missing.get("username").asText(),
                missing.get("password").asText());

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Password is required"),
                "Expected 'Password is required' error was not shown!");
    }
}
