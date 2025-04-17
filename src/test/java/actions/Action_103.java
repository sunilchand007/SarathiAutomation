package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.ScrutinyPage;

public class Action_103 extends BasePage{
WebDriver driver;
	
	public void scrutiny() {
		scrooldown(driver);
		// Scrutiny
		ScrutinyPage scrutinyPage = new ScrutinyPage(driver);
		scrutinyPage.Clickon_VerificationofDocuments_Link();
		scrutinyPage.Clickon_prooflinks();
		scrutinyPage.Clickon_Scrutiny_Link();
		
		if(driver.getPageSource().contains("Photo and Signature are Visible Properly")) {
			System.out.println("Displaying message --> Photo and Signature are Visible Properly");
			driver.findElement(By.xpath("//input[@type='radio'][1]")).click();
			}
			if(driver.getPageSource().contains("Online verify candidate?"))
			driver.findElement(By.xpath("//input[@id='uploadedFile']"))
			.sendKeys(System.getProperty("user.dir") + "\\SampleUploadFiles\\TestPDF3kb.pdf");
	}
}
