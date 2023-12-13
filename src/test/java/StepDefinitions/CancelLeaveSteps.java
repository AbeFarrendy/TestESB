package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
public class CancelLeaveSteps {
    WebDriver driver = null;

    @Given("user is logged in5")
    public void user_is_logged_in5() throws InterruptedException {
        System.out.println("In Step - user is logged in5");

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path is : "+projectPath);
        System.getProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // User enters LOGIN + PASSWORD
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);

        // User clicks LOGIN
        driver.findElement(By.className("orangehrm-login-button")).click();
        Thread.sleep(1000);
    }
    @Given("user is in my leave")
    public void user_is_in_my_leave() throws InterruptedException {
        System.out.println("In Step - user is in my leave");

        // User clicks LEAVE and MY LEAVE
        driver.findElement(By.linkText("Leave")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("My Leave")).click();
        Thread.sleep(1000);
    }
    @When("user clicks cancel")
    public void user_clicks_cancel() throws InterruptedException {
        System.out.println("In Step - user clicks cancel");
        // User clicks CANCEL
        driver.findElement(By.className("oxd-button--label-warn")).click();
        Thread.sleep(1000);
    }
    @Then("user successfully cancels leave")
    public void user_successfully_cancels_leave() throws InterruptedException {
        System.out.println("In Step - user successfully cancels leave");
        Thread.sleep(5000);

        // Close browser
        driver.close();
        driver.quit();
    }
}
