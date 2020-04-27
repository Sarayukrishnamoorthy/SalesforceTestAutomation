package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountsReportTC14 extends BrowserUtitlity{

	public static void main(String[] args) throws Exception{
		launchBrowser("ch");
		login(false);
		Thread.sleep(2000);
		
		
		
		// Click on Account Tab
		WebElement accountsTab = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		waitForVisibility(accountsTab);
		accountsTab.click();
		//Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		//click on merge accounts link
		WebElement accountLink = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		waitForVisibility(accountLink);
		accountLink.click();
		Thread.sleep(2000);
		
		WebElement createdDate = driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		createdDate.click();
		Thread.sleep(1000);
		waitForVisibility(driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")));
		driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
		
		WebElement FromDate = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		waitForVisibility(FromDate);
		FromDate.click();
		Thread.sleep(2000);
		
		//waitForVisibility(driver.findElement(By.xpath("//table[@id='ext-comp-1112']//td[@class='x-btn-mc']")));
		WebElement todayFrom = driver.findElement(By.xpath("//table[@id='ext-comp-1112']//td[@class='x-btn-mc']"));
		waitForVisibility(todayFrom);
		todayFrom.click();
		Thread.sleep(2000);
		
		WebElement ToDate = driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		waitForVisibility(ToDate);
		ToDate.click();
		Thread.sleep(2000);
		
		WebElement todayTo = driver.findElement(By.xpath("//table[@id='ext-comp-1114']//td[@class='x-btn-mc']"));
		waitForVisibility(todayTo);
		todayTo.click();
		Thread.sleep(2000);
		
		
		WebElement saveReport = driver.findElement(By.xpath("//table[@id='saveReportBtn']//td[@class='x-btn-mc']"));
		waitForVisibility(saveReport);
		saveReport.click();
		Thread.sleep(2000);

		WebElement promptReportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		if (promptReportName.isDisplayed()) {
			waitForVisibility(promptReportName);
			promptReportName.clear();
			promptReportName.sendKeys("AcReport1");
		}
		
		WebElement uniqueReportName = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		if (uniqueReportName.isDisplayed()) {
			waitForVisibility(uniqueReportName);
			uniqueReportName.clear();
			uniqueReportName.sendKeys("AcReport1");
		}
		Thread.sleep(2000);
		WebElement saveandRunReport = driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']//td[@class='x-btn-mc']"));
		waitForVisibility(saveandRunReport);
		saveandRunReport.click();
		Thread.sleep(2000);
		
		quitBrowser();
	}
}
