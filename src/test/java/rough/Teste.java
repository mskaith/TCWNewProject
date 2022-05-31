package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teste {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://apps.timeclockwizard.com/Login?Subdomain=qcqae");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("UserName")).sendKeys("sa");
		driver.findElement(By.id("Password")).sendKeys("tbtcw@2!!2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@value='LogIn']")).click();
		Thread.sleep(5000);

		String dashboardTxt = driver.findElement(By.id("site_name")).getText();
		System.out.println(dashboardTxt);

		Actions act = new Actions(driver);
		WebElement sideBar = driver.findElement(By.xpath("//span[@class='sidebar_menu_link' and text()='Schedule']"));
		act.moveToElement(sideBar).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,500)");
		// js.executeScript("scroll(0, 250)");
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//span[@class='sidebar_menu_link' and text()='Support']")));

	}

}
