import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {

    public String browser = "firefox";
    public WebDriver driver;

    @Test
    public void testLogin() {
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("http://opencart.qatestlab.net/index.php?route=account/login");
      driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("bonfacegithinji641@gmail.com");
       driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("BK1234");
        String pageTitle=driver.getTitle();
        String title="http://opencart.qatestlab.net/index.php?route=account/success";
        Assert.assertEquals(pageTitle, title, "Page title does not match expected title");

        

        // You can add more test steps here for the login process

      
    }
}
