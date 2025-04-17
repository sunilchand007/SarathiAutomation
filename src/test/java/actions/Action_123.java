package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.UploadDocumentsStage01Page;
import pageobjects.UploadDocumentsStage03Page;

public class Action_123 {

	WebDriver driver;
	
	public Action_123(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void uploadDocuments() throws IOException {
		
		System.out.println("Inside Upload Documents Flow");
		UploadDocumentsStage01Page uploadDocumentsStage01 = new UploadDocumentsStage01Page(driver);
		uploadDocumentsStage01.click_okbutton();
		// uploadDocumentsStage01.click_on_SubmitButtoninUploadDocument01();
		// UploadDocumentsStage02Page uploadDocumentsStage02=new
		// UploadDocumentsStage02Page(driver);
		// uploadDocumentsStage02.click_on_SubmitButtoninUploadDocument02();
		UploadDocumentsStage03Page uploadDocumentsStage03 = new UploadDocumentsStage03Page(driver);
		uploadDocumentsStage03.uploadDocuments();
		
	}
}
