package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class DashBoard extends BaseTest {
	@Test(priority=1)
	public void landingOnDashBoard() {
		String dashboardTxt=driver.findElement(By.id(OR.getProperty("dashboardTl_id"))).getText();
		
		Assert.assertEquals(dashboardTxt, "Dashboard");
		
	}

}
