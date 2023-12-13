package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class UpdatePersonalDetailsSteps {

    WebDriver driver = null;

    @Given("user is logged in2")
    public void user_is_logged_in2() throws InterruptedException {
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
    @And("user is in my info personal details")
    public void user_is_in_my_info_personal_details() throws InterruptedException {
        System.out.println("In Step - user is in my info personal details");

        // User clicks MY INFO
        driver.findElement(By.linkText("My Info")).click();
        Thread.sleep(1000);
    }
    @When("user updates personal details")
    public void user_updates_personal_details() throws InterruptedException {
        System.out.println("In Step - user updates personal details");

        driver.findElement(By.name("firstName")).sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        driver.findElement(By.name("firstName")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        driver.findElement(By.name("firstName")).sendKeys("Carl");
        Thread.sleep(500);

        driver.findElement(By.name("middleName")).sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        driver.findElement(By.name("middleName")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        driver.findElement(By.name("middleName")).sendKeys("CJ");
        Thread.sleep(500);

        driver.findElement(By.name("lastName")).sendKeys(Keys.SHIFT, Keys.ARROW_UP);
        driver.findElement(By.name("lastName")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        driver.findElement(By.name("lastName")).sendKeys("Johnson");
        Thread.sleep(3000);
    }
    @And("user clicks save")
    public void user_clicks_save() throws InterruptedException {
        System.out.println("In Step - user clicks save");
        driver.findElement(By.xpath("//div[5]/button")).click();
        Thread.sleep(3000);
    }
    @Then("user successfully updated personal details")
    public void user_successfully_updated_personal_details() throws InterruptedException {
        System.out.println("In Step - user successfully updated personal details");
        driver.navigate().refresh();

        Thread.sleep(5000);

        // Close browser
        driver.close();
        driver.quit();
    }

}
