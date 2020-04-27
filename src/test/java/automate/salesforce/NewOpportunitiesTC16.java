package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewOpportunitiesTC16 extends BrowserUtitlity{
	
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
		
		//input[@name='new'] --> new Button
		WebElement newBtn = driver.findElement(By.xpath("//input[@name='new']"));
		waitForVisibility(newBtn);
		newBtn.click();
		Thread.sleep(2000);
		
		//input[@id='opp3'] --> opportunity name
		WebElement oppName = driver.findElement(By.xpath("//input[@id='opp3']"));
		waitForVisibility(oppName);
		oppName.sendKeys("Opportunities1");
		Thread.sleep(2000);
		
		//input[@id='opp4'] --> account name
		WebElement accName = driver.findElement(By.xpath("//input[@id='opp4']"));
		waitForVisibility(accName);
		accName.sendKeys("primary");
		Thread.sleep(2000);
		
		//select[@id='opp5'] --> New Customer drop down
		Select leadSource = new Select(driver.findElement(By.xpath("//select[@id='opp6']")));
		leadSource.selectByVisibleText("Web");
		Thread.sleep(2000);
		
		//select[@id='opp6']--->Drop down -> Web
//		Select allOpporDropDown = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
//		WebElement opportunitiesBtn = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
//		waitForVisibility(opportunitiesBtn);
//		opportunitiesBtn.click();
//		Thread.sleep(2000);
		
		//input[@id='opp9'] ---->	//a[contains(@class,'calToday')]
		WebElement closeDateBtn = driver.findElement(By.xpath("//input[@id='opp9']"));
		waitForVisibility(closeDateBtn);
		closeDateBtn.click();
		Thread.sleep(2000);
		
		WebElement closeDate = driver.findElement(By.xpath("//a[contains(@class,'calToday')]"));
		waitForVisibility(closeDate);
		closeDate.click();
		
		//select[@id='opp11'] --> DRop down  -->Need Analysis
		Select stageDropDown = new Select(driver.findElement(By.xpath("//select[@id='opp11']")));
		stageDropDown.selectByVisibleText("Needs Analysis");
		Thread.sleep(2000);
		
		
		
		//input[@id='opp12'] --> percentage
		WebElement percentage = driver.findElement(By.xpath("//input[@id='opp12']"));
		waitForVisibility(percentage);
		percentage.clear();
		percentage.sendKeys("30");
		Thread.sleep(2000);
		
		//input[@id='opp17'] --> example campaign
		WebElement campaign = driver.findElement(By.xpath("//input[@id='opp17']"));
		waitForVisibility(campaign);
		campaign.sendKeys("exampleCampaign");
		Thread.sleep(2000);
		
		//div[contains(@class,'pbBottomButtons')]//input[1] -- save opportunities
		WebElement saveBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		waitForVisibility(saveBtn);
		saveBtn.click();
		
		Thread.sleep(4000);
		quitBrowser();
	}

	
	
}
