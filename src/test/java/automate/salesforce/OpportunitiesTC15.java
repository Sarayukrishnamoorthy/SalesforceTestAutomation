package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpportunitiesTC15 extends BrowserUtitlity{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement opportunitiesBtn = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		waitForVisibility(opportunitiesBtn);
		opportunitiesBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		Select allOpporDropDown = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		WebElement visibleEle = allOpporDropDown.getFirstSelectedOption();
		if(visibleEle.isDisplayed()) {
			System.out.println("Drop Down is present in opportunities Tab");
		} else {
			System.out.println("Drop Down failed");
		}
		Thread.sleep(2000);
		quitBrowser();
	}

}
