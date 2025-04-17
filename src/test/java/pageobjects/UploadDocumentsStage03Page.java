package pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkLibrary.BasePage;

public class UploadDocumentsStage03Page extends BasePage {

	
	WebDriver driver;

	boolean stepstatus;

	public UploadDocumentsStage03Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void uploadDocuments() throws IOException{
		
		int Numberofuploads = calculateNumberOfDocuments();
		System.out.println("Number of Docs to Upload is "+ Numberofuploads);
		for (int i=0 ; i< Numberofuploads ; i++)
		{
			System.out.println("Performing -"+ (i+1) + " Upload");
			selectFirstOptionForDocumentsDropdown();
			selectFirstOptionForProofsDropdown();
			clickBrowseButtonUploadFile_clickUpload_clickConfirm_clickNext();
		}	
		
	}
		
	public int calculateNumberOfDocuments() {	
		
		WebElement DocumentType = driver.findElement(By.xpath("//select[@name='documentType']"));
		Select Doc = new Select(DocumentType);
		List<WebElement> options = Doc.getOptions();
		for (WebElement option: options){
			System.out.println("The options are " + option.getText());
		}
		int numberOfDocuments = options.size() - 1;
		
		return numberOfDocuments;
		
	}
	
	public void selectFirstOptionForDocumentsDropdown(){
		
		WebElement DocumentType = driver.findElement(By.xpath("//select[@name='documentType']"));
		Select Doc = new Select(DocumentType);
		List<WebElement> options = Doc.getOptions();
		System.out.println("Required Doc is " + options.get(1).getText());
		Doc.selectByIndex(1);
		stepstatus = clickElement(DocumentType);
		reportEvent(stepstatus, "Able to click First Option For Documents Dropdown ", "Unable to click on First Option For Documents Dropdown", driver, true);
	}
	
	public void selectFirstOptionForProofsDropdown() {
		
		
		WebElement ProofDocumentType = driver.findElement(By.xpath("//select[@name='relatedDocuments']"));
		Select profDoc = new Select(ProofDocumentType);
		List<WebElement> options = profDoc.getOptions();

		System.out.println("Required proofDoc is " + options.get(1).getText());
		profDoc.selectByIndex(1);
		if (alertExist(driver)) {
			acceptAlert(driver);
			reportEvent(stepstatus, "Able to click First Option For proof Documents Dropdown ", "Unable to click on First Option For proof Documents Dropdown", driver, true);


		}

	}
	public void clickBrowseButtonUploadFile_clickUpload_clickConfirm_clickNext() throws IOException {
		wait(1);
		
		System.out.println("About to click browse button");
		driver.findElement(By.xpath("//input[@id='uploadedFile']"))
				.sendKeys(System.getProperty("user.dir") + "\\SampleUploadFiles\\Report.pdf");
		System.out.println("About to click upload button");
		driver.findElement(By.xpath("//input[@id='upload']")).click();
		reportEvent(stepstatus, "Able to click upload Documents Dropdown ", "Unable to click upload Documents Dropdown", driver, true);

		
		try {
			System.out.println("About to click Confirm button");
			driver.findElement(By.xpath("//input[@id='confirm']")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='preloader']")));
			
			//wait(1);
			if (alertExist(driver)) {
				acceptAlert(driver);
				driver.findElement(By.xpath("//input[@id='confirm']")).click();
				reportEvent(stepstatus, "Able to click Confirm For Documents Dropdown ", "Unable to click Confirm For Documents Dropdown", driver, true);

			} else {
				System.out.println("There is no alert present");
			}
			
			if (driver.getPageSource().contains("All Documents are Uploaded Successfully")) {
				String ftext = 	driver.findElement(By.xpath("//label[text()='All Documents are Uploaded Successfully']")).getText();
				System.out.println("The String found was " + ftext);
				if (ftext.equals("All Documents are Uploaded Successfully")) {
					System.out.println("Inside clickBrowseButtonUploadFile_clickUpload_clickConfirm_clickNext About to click Next button");
					driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
					reportEvent(stepstatus, "Able to Upload ALL Documents  ", "Unable to Upload All Documents", driver, true);

				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
	
}
	
	
	
	
	
	
	
	
	


