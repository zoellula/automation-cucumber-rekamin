package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;

    @Given("^User launch the app web$")
    public void userLaunchTheAppWeb() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000L);
    }

    @And("User input registered email {string}")
    public void userInputRegisteredEmail(String email) {
        driver.findElement(By.name("user-name")).sendKeys(new CharSequence[]{email});
    }

    @And("User input registered password {string}")
    public void userInputRegisteredPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(new CharSequence[]{password});
    }

    @When("^user submit button login$")
    public void userSubmitButtonLogin() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("^User success login$")
    public void userSuccessLogin() {
        driver.findElement(By.className("app_logo"));
    }

    @Then("User failed login and show warning")
    public void userFailedLoginAndShowWarning() {
        driver.findElement(By.xpath("//*[contains(text(), 'Username and password do not match any user in this service')]"));
    }

    @Then("User failed login and show warning locked")
    public void userFailedLoginAndShowWarningLocked() {
        driver.findElement(By.xpath("//*[contains(text(), 'Sorry, this user has been locked out.')]"));
    }

    @Then("user back to login page")
    public void userBackToLoginPage() {
        driver.findElement(By.className("login_logo"));
    }

    @When("user access inventory page")
    public void userAccessInventoryPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/inventory.html");
        Thread.sleep(1000);
    }

    @Then("user can't access another page after logout")
    public void userCanTAccessAnotherPageAfterLogout() {
        driver.findElement(By.xpath("//*[contains(text(), 'You can only access')]"));
    }

    @Then("user can't access another page before login")
    public void userCanTAccessAnotherPageBeforeLogin() {
        driver.findElement(By.xpath("//*[contains(text(), 'You can only access')]"));
    }

    @When("user access another page")
    public void userAccessAnotherPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/cart.html");
        Thread.sleep(1000L);
    }

    @When("user click menu burger")
    public void userClickMenuBurger() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user click menu logout")
    public void userClickMenuLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @When("User add product to cart")
    public void userAddProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("cart will show count badge product")
    public void cartWillShowCountBadgeProduct() {
        driver.findElement(By.className("shopping_cart_badge"));
    }

    @And("User click button remove from product")
    public void userClickButtonRemoveFromProduct() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @Then("Button will change to button Add")
    public void buttonWillChangeToButtonAdd() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    @Then("cart page will show list product")
    public void cartPageWillShowListProduct() {
        driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Backpack')]"));
    }

    @When("User click button cart")
    public void userClickButtonCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("User click button checkout")
    public void userClickButtonCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("page will show form information")
    public void pageWillShowFormInformation() {
        driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Your Information')]"));
    }

    @When("User click button Continue")
    public void userClickButtonContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("page will show overview order")
    public void pageWillShowOverviewOrder() {
        driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Overview')]"));
    }

    @When("User click button finish")
    public void userClickButtonFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @And("User input first name {string}")
    public void userInputFirstName(String firstName) {
        driver.findElement(By.name("firstName")).sendKeys(firstName);
    }

    @And("User input last name {string}")
    public void userInputLastName(String lastName) {
        driver.findElement(By.name("lastName")).sendKeys(lastName);
    }

    @And("User input zip code {string}")
    public void userInputZipCode(String postalCode) {
        driver.findElement(By.name("postalCode")).sendKeys(postalCode);
    }

    @Then("page will show completion order page")
    public void pageWillShowCompletionOrderPage() {
        driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Complete!')]"));
    }

    @Then("User failed checkout and show error required")
    public void userFailedCheckoutAndShowErrorRequired() {
        driver.findElement(By.xpath("//*[contains(text(), 'required')]"));
    }
}
