package automate.salesforce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeveloperConsoleTC08 extends BrowserUtitlity {
		
		public static void main(String[] args) throws Exception {
			launchBrowser("ch");
			login(false);
			
			WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
			waitForVisibility(userNavBtn);
			userNavBtn.click();
			Thread.sleep(2000);
			
			WebElement myProfile =  driver.findElement(By.xpath("//a[contains(@class,'debugLogLink menuButtonMenuLink')]"));
			waitForVisibility(myProfile);
			myProfile.click();
			Thread.sleep(2000);
			
			Set<String> windows = driver.getWindowHandles();
			String[] window = windows.toArray(new String[windows.size()]);
			driver.switchTo().window(window[1]);
			
			driver.manage().window().maximize();
			waitForVisibility(driver.findElement(By.xpath("//span[@id='editorMenuEntry-btnInnerEl']")));
			Thread.sleep(1000);
			driver.close();
			
			Thread.sleep(3000);
			
			quitBrowser();

	}

}
