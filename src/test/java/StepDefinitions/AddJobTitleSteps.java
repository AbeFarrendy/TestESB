package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
public class AddJobTitleSteps {

    WebDriver driver = null;

    @Given("user is logged in4")
    public void user_is_logged_in4() throws InterruptedException {
        System.out.println("In Step - user is logged in4");

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
    @Given("user is in my info job")
    public void user_is_in_my_info_job() throws InterruptedException {
        System.out.println("In Step - user is in my info job");

        // User clicks MY INFO
        driver.findElement(By.linkText("My Info")).click();
        Thread.sleep(1000);
        // User clicks JOB
        driver.findElement(By.linkText("Job")).click();
        Thread.sleep(1000);
    }
    @When("user updates job title")
    public void user_updates_job_title() throws InterruptedException {
        // User attempts to change Job Title
        // NOTE: element not interactable
        driver.findElement(By.xpath("//div[2]/div/div[2]/div/div"))
                .sendKeys("HR Manager");
        Thread.sleep(5000);
    }
    @Then("user attempted to update job title")
    public void user_attempted_to_update_job_title()
    {
        // Close browser
        driver.close();
        driver.quit();
    }

}
