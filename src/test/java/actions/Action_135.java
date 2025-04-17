package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import pageobjects.UploadPhoto_SignaturePage;

public class Action_135 extends BasePage {
	WebDriver driver;

	
	public Action_135(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void uplaodphotoandsignature() {
		
		UploadPhoto_SignaturePage uploadPhotoandSign = new UploadPhoto_SignaturePage(driver);
		uploadPhotoandSign.Clickon_Browse_Button1();
		uploadPhotoandSign.Clickon_Browse_Button2();
		uploadPhotoandSign.Clickon_UploadandViewfiles();
		uploadPhotoandSign.Clickon_SavephotoandSignature();
		uploadPhotoandSign.Clickon_Next();
		
	}
}
