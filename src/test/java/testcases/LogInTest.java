package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.DataUtil;

public class LogInTest extends BaseTest {
	@Test(priority = 1, dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void doLogin(String userName, String password) throws InterruptedException {

		type("username_id", userName);
		type("psswd_id", password);
		Thread.sleep(3000);
		click("loginBtn_xp");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLoading")));
		System.out.println("1");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		System.out.println("2");

		String dashboardTxt = driver.findElement(By.id(OR.getProperty("dashboardTl_id"))).getText();

		Assert.assertEquals(dashboardTxt, "Dashboard");

		// Assert.fail("Forced Failure");

	}

}
