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
       driver.findElement(By.xpath("//input[@value='Login']")).click();
       
       
        String pageTitle=driver.getTitle();
        String title="http://opencart.qatestlab.net/index.php?route=account/success";
        Assert.assertEquals(pageTitle, title, "Page title does not match expected title");
        //get the title text to verify user has logged in
        WebElement heading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        String headingText = heading.getText();
        String text="Your Account Has Been Created!";
        Assert.assertEquals(heading, headingText, "Text does not match expected value");
        
        //click change your password button
        
        driver.findElement(By.xpath("//a[normalize-space()='Change your password']")).click();
        
    
    }
    @Test
    public void tearDown() {
    	driver.quit();
    }
    
  
}
