package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginLogoutSteps {

    WebDriver driver = null;
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("In Step - user is on login page");

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path is : "+projectPath);
        System.getProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        System.out.println("In Step - user enters username and password");
        // User enters USERNAME + PASSWORD
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        System.out.println("In Step - user clicks on login button");
        // User clicks LOGIN
        driver.findElement(By.className("orangehrm-login-button")).click();
        Thread.sleep(1000);
    }
    @Then("user is navigated to the homepage")
    public void user_is_navigated_to_the_homepage() throws InterruptedException {
        System.out.println("In Step - user is navigated to the homepage");
        // Verify USERDROPDOWN is visible
        driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed();
        Thread.sleep(3000);
    }

    @And("user logs out")
    public void user_logs_out() throws InterruptedException {
        System.out.println("In Step - user logs out");
        // User clicks USERDROPDOWN and LOGOUT
        driver.findElement(By.className("oxd-userdropdown-name")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(3000);

        // Close browser...
        driver.close();
        driver.quit();
    }
}
