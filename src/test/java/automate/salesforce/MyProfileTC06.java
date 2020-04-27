package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyProfileTC06 extends BrowserUtitlity {
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitForVisibility(userNavBtn);
		userNavBtn.click();
		Thread.sleep(2000);
		
		WebElement myProfile =  driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		waitForVisibility(myProfile);
		myProfile.click();
		Thread.sleep(2000);
		
		waitForVisibility(driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")));
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();
		Thread.sleep(2000);
		
		
		//WebElement aboutFrameEle = driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.id("aboutTab")).click();
		Thread.sleep(2000);
		
		WebElement lastNameEle = driver.findElement(By.id("lastName"));
		lastNameEle.clear();
		String lastName = ReadUserData.getUserData("lastName");
		lastNameEle.sendKeys(lastName);
		
		WebElement saveAllEle = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveAllEle.click();
		
		Thread.sleep(2000);
		
		WebElement postEle = driver.findElement(By.id("publisherAttachTextPost"));
		waitForVisibility(postEle);
		postEle.click();
		
		WebElement postFrame = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		waitForVisibility(postFrame);
		driver.switchTo().frame(postFrame);
		
		WebElement postText = driver.findElement(By.xpath("//html[1]/body[1]"));
		postText.click();
		postText.sendKeys("Post Hello World.....!");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		WebElement sharePost = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		sharePost.click();
		Thread.sleep(2000);
		
		WebElement FileEle = driver.findElement(By.xpath("//span[contains(text(),'File')]"));
		waitForVisibility(FileEle);
		FileEle.click(); 
		
		WebElement uploadFileEle = driver.findElement(By.id("chatterUploadFileAction"));
		waitForVisibility(uploadFileEle);
		uploadFileEle.click();
		
		WebElement chooseFileEle = driver.findElement(By.id("chatterFile"));
		waitForVisibility(chooseFileEle);
		String sFile = System.getProperty("user.dir") + "/FileUploadTestDoc.docx";
		chooseFileEle.sendKeys(sFile);
		WebElement shareFile = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		shareFile.click();
		
		Thread.sleep(2000);
		
		WebElement profilePicEle = driver.findElement(By.id("displayBadge"));
		mouseHover(profilePicEle);
		Thread.sleep(2000);
		
		WebElement addPhotoLinkEle = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		waitForVisibility(addPhotoLinkEle);
		addPhotoLinkEle.click();
		Thread.sleep(2000);
		
		WebElement photoFrameEle = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(photoFrameEle);
		String photoFile = System.getProperty("user.dir") + "/profilePic.jpg";
		WebElement choosePhotoEle = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		choosePhotoEle.sendKeys(photoFile);
		Thread.sleep(2000);
		
		WebElement saveBtnEle = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		saveBtnEle.click();
		Thread.sleep(2000);
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']")));
		Actions action = new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='imgCrop_handle imgCrop_handleNW']")), 100, 20);
		driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		quitBrowser();
		
	}
}
