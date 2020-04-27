package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OpportunitiesPipelineTC17 extends BrowserUtitlity {

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
		
		WebElement pipeLineLink = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		waitForVisibility(pipeLineLink);
		pipeLineLink.click();
		
		
		Thread.sleep(4000);
		quitBrowser();
	}
}
