package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TodaysLeadsTC23 extends BrowserUtitlity {
	
	

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		openLeadTab(true);
		Select allLeadsDropDown = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		allLeadsDropDown.selectByIndex(3);
		Thread.sleep(3000);
		logout();
		Thread.sleep(2000);
		quitBrowser();
	}
	
	static void openLeadTab(boolean firstTime) throws Exception {
		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		waitForVisibility(opportunitiesBtn);
		opportunitiesBtn.click();
		Thread.sleep(2000);
		
		if (firstTime) {
			// Dismiss prompt window for switch to lightening experience
			WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
			if (promptEle.isDisplayed()) {
				waitForVisibility(promptEle);
				promptEle.click();
			}
		}
	}
}
