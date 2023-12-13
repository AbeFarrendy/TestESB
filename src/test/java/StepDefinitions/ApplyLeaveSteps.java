package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ApplyLeaveSteps {

    WebDriver driver = null;

    @Given("user is logged in")
    public void user_is_logged_in() throws InterruptedException {
        System.out.println("In Step - user is logged in");

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
    @Given("user is in apply leave")
    public void user_is_in_apply_leave() throws InterruptedException {
        System.out.println("In Step - user is in apply leave");

        // User clicks LEAVE and APPLY
        driver.findElement(By.linkText("Leave")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Apply")).click();
        Thread.sleep(1000);

    }
    @When("user inputs leave details")
    public void user_inputs_leave_details() throws InterruptedException {
        System.out.println("In Step - user inputs leave details");
        // User selects LEAVE TYPE
        // NOTE: Will not be accessible when Leave Balance is 0.
        driver.findElement(By.className("oxd-select-text--arrow")).click();
        Thread.sleep(1000);
        // User selects "CAN - Bereavement"
        driver.findElement(By.xpath("//div[2]/span")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div/div")).click();
        //driver.findElement(By.className("oxd-select-dropdown")).sendKeys(Keys.DOWN, Keys.ENTER);
        /*WebElement dropdown = driver.findElement(By.className("oxd-select-dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("CAN - Bereavement");*/

        // User selects FROM_DATE
        driver.findElement(By.xpath("//div/div[2]/div/div/input")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[18]/div")).click();
        Thread.sleep(500);
        // User selects TO_DATE
        driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/input")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[20]/div")).click();
        Thread.sleep(500);

        // User adds COMMENT
        driver.findElement(By.className("oxd-textarea")).sendKeys("Lorem ipsum dolor si amet");
        Thread.sleep(1000);
    }
    @When("user clicks apply")
    public void user_clicks_apply() throws InterruptedException {
        System.out.println("In Step - user clicks apply");
        driver.findElement(By.xpath("//div[5]/button")).click();
        Thread.sleep(1000);
    }
    @Then("user successfully applied leave")
    public void user_successfully_applied_leave() throws InterruptedException {
        System.out.println("In Step - user successfully applied leave");
        Thread.sleep(5000);

        // Close browser
        driver.close();
        driver.quit();
    }

}
