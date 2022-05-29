package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class Reports extends BaseTest {
	@Test(priority = 1)
	public void clickOnReportTab() {
		WebElement sidebarMenuLst = driver.findElement(By.xpath(OR.getProperty("sidebarMenuLst_xp")));
		act.moveToElement(sidebarMenuLst);
		
	}

}
