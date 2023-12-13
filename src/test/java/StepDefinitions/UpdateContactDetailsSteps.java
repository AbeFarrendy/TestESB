package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class UpdateContactDetailsSteps {

    WebDriver driver = null;

    @Given("user is logged in3")
    public void user_is_logged_in3() throws InterruptedException {
        System.out.println("In Step - user is logged in2");

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
    @Given("user is in my info contact details")
    public void user_is_in_my_info_contact_details() throws InterruptedException
    {
        System.out.println("In Step - user is in my info contact details");
        // User clicks MY INFO
        driver.findElement(By.linkText("My Info")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Contact Details")).click();
        Thread.sleep(1000);
    }
    @When("user updates contact details")
    public void user_updates_contact_details() throws InterruptedException
    {
        System.out.println("In Step - user updates contact details");
        // User updates Street Address 1
        driver.findElement(By.xpath("//div[2]/input")).sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        driver.findElement(By.xpath("//div[2]/input")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[2]/input")).sendKeys("Test Street 11");
        Thread.sleep(500);

        // User updates Street Address 2
        driver.findElement(By.xpath("//div[2]/div/div[2]/input")).sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        driver.findElement(By.xpath("//div[2]/div/div[2]/input")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[2]/div/div[2]/input")).sendKeys("Singapore");
        Thread.sleep(500);

        // User updates Home Number
        driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/input")).sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/input")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/input")).sendKeys("012312311");
        Thread.sleep(500);

        // User updates Mobile Number
        driver.findElement(By.xpath("//div[2]/div/div[2]/div/div[2]/input")).sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        driver.findElement(By.xpath("//div[2]/div/div[2]/div/div[2]/input")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[2]/div/div[2]/div/div[2]/input")).sendKeys("011223344");
        Thread.sleep(500);
    }
    @When("user clicks save2")
    public void user_clicks_save2() throws InterruptedException
    {
        System.out.println("In Step - user clicks save2");
        driver.findElement(By.className("oxd-button--medium")).click();
        Thread.sleep(1000);
    }
    @Then("user successfully updated contact details")
    public void user_successfully_updated_contact_details() throws InterruptedException {
        System.out.println("In Step - user successfully updated contact details");
        Thread.sleep(5000);

        // Close browser
        driver.close();
        driver.quit();
    }
}
