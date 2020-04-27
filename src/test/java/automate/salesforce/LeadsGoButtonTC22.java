package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class LeadsGoButtonTC22  extends BrowserUtitlity {
	
	

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		
		openLeadTab(true);
		
		Select allLeadsDropDown = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		allLeadsDropDown.selectByIndex(1);
		
		Thread.sleep(2000);
		logout();
		login(false);
		Thread.sleep(2000);
		
		openLeadTab(false);
		
		WebElement goBtn = driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		waitForVisibility(goBtn);
		goBtn.click();
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


