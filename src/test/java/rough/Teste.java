package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teste {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://apps.timeclockwizard.com/Login?Subdomain=tcwtestbyami");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("UserName")).sendKeys("ami");
		driver.findElement(By.id("Password")).sendKeys("tbtcw@2!!2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@value='LogIn']")).click();
		Thread.sleep(5000);
		
		String dashboardTxt=driver.findElement(By.id("site_name")).getText();	
		System.out.println(dashboardTxt);

	}

}
