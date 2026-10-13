# Swag Labs Automation

UI automation framework for https://www.saucedemo.com/ built with:
- Java + Selenium WebDriver
- TestNG
- Page Object Model (POM)
- Data-Driven Testing (JSON)

## Project Structure
- `src/main/java/pages` → Page Objects (LoginPage, InventoryPage)
- `src/main/java/utils` → DataDriven (jsonReader)
- `src/test/java/base` → BaseTest (browser setup/teardown)
- `src/test/java/tests` → Test classes
- `testData` → testData.json

## How to Run