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
		driver.switchTo().frame(OR.getProperty("tsVReportFrame_id"));
		String tsVReportStdTtl = driver.findElement(By.xpath(OR.getProperty("tsVReportStdTtl_xp"))).getText();
		WebElement tsEmpName = driver.findElement(By.xpath(OR.getProperty("tsEmpName_xp")));
		wait.until(ExpectedConditions.visibilityOf(tsEmpName));
		//System.out.println(employee);
		Assert.assertEquals(tsVReportStdTtl, "Standard Timesheet Report");
		
	}
	@Test(priority=3)
	public void tsDetailedReportPage() throws InterruptedException {
		//Thread.sleep(5000);
		driver.switchTo().defaultContent();
		WebElement tsDetailedBtn = driver.findElement(By.xpath(OR.getProperty("tsDetailedBtn_xp")));
		act.moveToElement(tsDetailedBtn).click().build().perform();
		click("tsVReportBtn_xp");
		driver.switchTo().frame(OR.getProperty("tsVReportFrame_id"));
		WebElement tsEmpName = driver.findElement(By.xpath(OR.getProperty("tsEmpName_xp")));
		wait.until(ExpectedConditions.visibilityOf(tsEmpName));
		String tsVReportDetailedTtl = driver.findElement(By.xpath(OR.getProperty("tsVReportDetailedTtl_xp"))).getText();
		Assert.assertEquals(tsVReportDetailedTtl,"Detailed Timesheet Report");
		
		
	}
}
