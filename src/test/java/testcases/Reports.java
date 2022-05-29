package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class Reports extends BaseTest {
	@Test(priority = 1)
	public void clickOnReportTab() {
		WebElement sidebarMenuLst = driver.findElement(By.xpath(OR.getProperty("sidebarMenuLst_xp")));
		act.moveToElement(sidebarMenuLst);
		WebElement reportTabBtn = driver.findElement(By.xpath(OR.getProperty("reportTabBtn_xp")));
		act.moveToElement(reportTabBtn).click().build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLoading")));
		//System.out.println("1");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		//System.out.println("2");
		String reportPageTtl = driver.findElement(By.xpath(OR.getProperty("reportPageTtl_xp"))).getText();
		Assert.assertEquals(reportPageTtl, "Reports");
	}
	@Test(priority=2)
	public void tsReportPage() {
		click("tsVReportBtn_xp");
	}
}
