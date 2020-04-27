package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ViewLeadsTC21 extends BrowserUtitlity {
	
	

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		waitForVisibility(opportunitiesBtn);
		opportunitiesBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		WebElement viewDDEle = driver.findElement(By.xpath("//select[@id='fcf']"));
		viewDDEle.click();
		Thread.sleep(2000);
		Select allLeadsDropDown = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		WebElement visibleEle = allLeadsDropDown.getFirstSelectedOption();
		if(visibleEle.isDisplayed()) {
			System.out.println("Drop Down is present in Leads Tab");
		} else {
			System.out.println("Drop Down failed");
		}
		
		Thread.sleep(4000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser();
	}
}

