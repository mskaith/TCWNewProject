package testcases;

import java.time.Duration;
import java.util.Hashtable;

import utilities.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class TimeSheet extends BaseTest {

	@Test(priority = 1)
	public void clickOnTimeSheet() throws InterruptedException {
		
		click("timesheetsidebar_xp");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLoading")));
		//System.out.println("1");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		//System.out.println("2");
		

	}

	@Test(priority = 2, dataProviderClass = DataUtil.class, dataProvider = "dp2")
	public void addTimeRecord(Hashtable<String, String> data) throws InterruptedException {
		WebElement addTimesheetBtn=driver.findElement(By.xpath(OR.getProperty("addTimesheet_xp")));
		js.executeScript("window.scrollBy(0,500)");
		act.moveToElement(addTimesheetBtn).click().build().perform();
		//click("addTimesheet_xp");
		WebElement employeeDropdown = driver.findElement(By.xpath(OR.getProperty("employeeedropdown_xp")));
		Select se = new Select(employeeDropdown);
		Thread.sleep(1000);
		String name = data.get("Employee");
		//System.out.println(name);
		log.info(name);
		se.selectByVisibleText(name);
		// click("AddTrStartDate_xp");
		/*
		 * WebElement startDate =
		 * driver.findElement(By.xpath(OR.getProperty("AddTStartDateBox_xp")));
		 * 
		 * String ss = startDate.getAttribute("value"); System.out.println(ss);
		 * log.info("the date is " + ss);
		 */
		WebElement startDateBox = driver.findElement(By.xpath(OR.getProperty("AddTStartDateBox_xp")));
		startDateBox.clear();
		String initailDate=data.get("startDateTr");
		//js.executeScript("arguments[0].value="+"'"+initailDate+"'"+"", startDateBox);
		//js.executeScript("arguments[0].value='11/2/2022'", startDateBox);
		startDateBox.sendKeys(data.get("startDateTr"));
		

	}

}
