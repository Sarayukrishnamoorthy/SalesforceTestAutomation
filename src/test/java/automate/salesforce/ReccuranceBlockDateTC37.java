package automate.salesforce;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReccuranceBlockDateTC37 extends BrowserUtitlity {
	
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement homeBtn = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		waitForVisibility(homeBtn);
		homeBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		WebElement todaysDate =  driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]"));
		waitForVisibility(todaysDate);
		System.out.println("username date link : " + todaysDate.getText());
		driver.findElement(By.linkText(todaysDate.getText())).click();
		Thread.sleep(2000);
		
		
		WebElement eightpmBtn = driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]"));
		waitForVisibility(eightpmBtn);
		eightpmBtn.click();
		Thread.sleep(2000);
		
		
		WebElement comboboxBtn = driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]"));
		waitForVisibility(comboboxBtn);
		comboboxBtn.click();
		Thread.sleep(2000);
		String handleWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String[] window = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(window[1]);
		
		driver.manage().window().maximize();
		
		waitForVisibility(driver.findElement(By.xpath("//a[contains(text(),'Other')]")));
		Thread.sleep(1000);
		WebElement secondWindEle = driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		String OtherText = secondWindEle.getText();
		driver.close();
		driver.switchTo().window(handleWindow);
		Thread.sleep(3000);
		
		WebElement subjectEle = driver.findElement(By.xpath("//input[@id='evt5']"));
		waitForVisibility(subjectEle);
		subjectEle.sendKeys(OtherText);
		Thread.sleep(2000);
		
		
		//System.out.println(driver.getTitle());
		WebElement EndDate = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		waitForVisibility(EndDate);
		EndDate.click();
		Thread.sleep(2000);
		
		WebElement Enddatadropdown = driver.findElement(By.xpath("//div[@id='timePickerItem_38']"));
		waitForVisibility(Enddatadropdown);
		Enddatadropdown.click();
		
		
		WebElement reccurrence = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		waitForVisibility(reccurrence);
		reccurrence.click();
		Thread.sleep(2000);
		
		
		WebElement updateWeekly = driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		waitForVisibility(updateWeekly);
		updateWeekly.click();
		Thread.sleep(2000);
		
		
		WebElement reccurrenceForEvery = driver.findElement(By.xpath("//input[@id='wi']"));
		waitForVisibility(reccurrenceForEvery);
		reccurrenceForEvery.click();
		reccurrenceForEvery.clear();
		reccurrenceForEvery.sendKeys("1");
		Thread.sleep(2000);
		
		
		//input[@id='RecurrenceEndDateOnly']
	    int noOfDays = 14; //i.e two weeks
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());            
	    calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
	    Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    String newDate = dateFormat.format(date);
	    System.out.println("two weeks from today : " + newDate);
	  
	    WebElement reccEndDate = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
		waitForVisibility(reccEndDate);
		reccEndDate.sendKeys(newDate);
		Thread.sleep(2000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[@id='ep']//div[contains(@class,'pbHeader')]//input[1]"));
		waitForVisibility(saveBtn);
		saveBtn.click();
		Thread.sleep(2000);
		
		
		WebElement monthView = driver.findElement(By.xpath("//img[contains(@class,'monthViewIcon')]"));
		waitForVisibility(monthView);
		monthView.click();
		Thread.sleep(3000);
		
		
		WebElement nextMonth = driver.findElement(By.xpath("//img[contains(@class,'nextCalArrow')]"));
		waitForVisibility(nextMonth);
		nextMonth.click();
		Thread.sleep(5000);
		quitBrowser();
	}

}