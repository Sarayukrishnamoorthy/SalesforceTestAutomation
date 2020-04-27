package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class QuaterlySummaryTC19 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		openOpportuniesTab(true);
		Thread.sleep(2000);
		Select intervals11 = new Select(driver.findElement(By.id("quarter_q")));
		intervals11.selectByIndex(0);
		Select include11 = new Select(driver.findElement(By.id("open")));
		include11.selectByIndex(0);
		clickRunReport();

		
		openOpportuniesTab(false);
		Thread.sleep(2000);
		Select intervals12 = new Select(driver.findElement(By.id("quarter_q")));
		intervals12.selectByIndex(0);
		Select include12= new Select(driver.findElement(By.id("open")));
		include12.selectByIndex(1);
		clickRunReport();
		
		
		openOpportuniesTab(false);
		Thread.sleep(2000);
		Select intervals13 = new Select(driver.findElement(By.id("quarter_q")));
		intervals13.selectByIndex(0);
		Select include13 = new Select(driver.findElement(By.id("open")));
		include13.selectByIndex(2);
		clickRunReport();
		
		
		openOpportuniesTab(false);
		Thread.sleep(2000);
		Select intervals21 = new Select(driver.findElement(By.id("quarter_q")));
		intervals21.selectByIndex(2);
		Select include21 = new Select(driver.findElement(By.id("open")));
		include21.selectByIndex(0);
		clickRunReport();
		
		
		openOpportuniesTab(false);
		Thread.sleep(2000);
		Select intervals22 = new Select(driver.findElement(By.id("quarter_q")));
		intervals22.selectByIndex(2);
		Select include22 = new Select(driver.findElement(By.id("open")));
		include22.selectByIndex(1);
		clickRunReport();
		
		openOpportuniesTab(false);
		Thread.sleep(2000);
		Select intervals23 = new Select(driver.findElement(By.id("quarter_q")));
		intervals23.selectByIndex(2);
		Select include23 = new Select(driver.findElement(By.id("open")));
		include23.selectByIndex(2);
		clickRunReport();
		
		Thread.sleep(4000);
		quitBrowser();
	}
	
	static void clickRunReport() throws Exception{
		WebElement RunReport = driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']"));
		waitForVisibility(RunReport);
		RunReport.click();
		Thread.sleep(2000);
	}
	
	static void openOpportuniesTab(boolean firstTime) throws Exception {
		WebElement opportunitiesBtn = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
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
