package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ApplicationStatusStage02Page extends BasePage {

	
	WebDriver driver;
	String nextFlow;
	int remainingFlows=0;
	boolean stepstatus;

	public ApplicationStatusStage02Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='UPLOAD DOCUMENTS']")
	WebElement Clickradio;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[@id='submitbtn']")
	WebElement Submit1;
	@FindBy(how = How.XPATH, using = "//input[@value='UPLOAD PHOTO AND SIGNATURE']")
	WebElement Clickradio2;

	public void Clickon_Proceed_Button() {
		
			stepstatus = clickElement(Proceed);
			reportEvent(stepstatus, "Able to click Proceed button", "Unable to click Proceed button", driver, true);

		}
	
	//@FindBy(how = How.XPATH, using = "//table[@id='tblAcctTo']")
//	WebElement TableViewStages;
	

	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement HOME;
	public void Clickon_HOME_Button() {
		stepstatus = clickElement(HOME);
		//reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver);
		//wait(10);
		//scrooldown(driver);
		
	}
	
	public String getAndEnterNextFlow(){
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr"));
		
	//	Step 2: Run a loop for all rows of the table
		for(int i =1; i<= rows.size(); i++){
			

			
			WebElement radioButton = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + i + "]/td[1]/input"));
			WebElement flow = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + i + "]/td[1]"));
			WebElement status = driver.findElement(By.xpath("//*[@id='tblAcctTo']/tbody/tr[" + i + "]/td[2]"));
			//Step 4: Also inside the loop, check if the radio button is selected, if it is then print the name of the flow and break out of the loop
			if(status.getText().contains("To be done by the Applicant")){
                if(!radioButton.isSelected()){
                    radioButton.click();
                }
            nextFlow = flow.getText();
           // System.out.println("The Next Flow is "+ nextFlow);
            break;
            }
			
		}
		return nextFlow;
	
	}

		
		
	public int numberOfRemainingFlows() {
		scrooldown(driver);
		System.out.println("inside no of remaining flows method");
		remainingFlows = 0;
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr"));
		for (int i = 1; i <= rows.size(); i++) {

			WebElement status = driver.findElement(By.xpath("//*[@id='tblAcctTo']/tbody/tr[" + i + "]/td[2]"));
			String text = status.getText();
			System.out.println("text of pending" + text);
			if (text.contains("To be done by the Applicant")) {
				remainingFlows++;

			}

		}

		return remainingFlows;

	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void GetNextFlow(){
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
		int count = ele.size();
		for (int i = 0; i < count; i++) {
			ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
			WebElement webele = ele.get(i);
			String text = webele.getText();
			//System.out.println("The Text of Flow is "+text);
			//WebElement Flowtext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
			//		+ "]/td[@id='statusId']/preceding-sibling::td"));
			//String flowtext = Flowtext.getText();
			//System.out.println("The Next Flow is "+ flowtext);

			if (!text.contains("Completed")) {

				if (!text.contains("Exempted")) {
					WebElement Flowtext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
							+ "]/td[@id='statusId']/preceding-sibling::td"));
					String flowtext = Flowtext.getText();
					
					if (flowtext.contains("UPLOAD DOCUMENTS")) {
						System.out.println("The Next Flow is "+ flowtext);
					//	UploadDocuments();
					} else if (flowtext.contains("UPLOAD PHOTO AND SIGNATURE")) {
						System.out.println("The Next Flow is "+ flowtext);
					//	UploadPhotoandSignature();
					} else if (flowtext.contains("FEE PAYMENT")) {
						System.out.println("The Next Flow is "+ flowtext);
					//	FeePayment();
					} else if (flowtext.contains("LL TEST SLOT BOOKIN")) {
						//LLSlotBooking();
						System.out.println("The Next Flow is "+ flowtext);
					} else if (flowtext.contains("DL TEST SLOT BOOKING")) {
						System.out.println("The Next Flow is "+ flowtext);
						//DLSlotbooking();
					} else if (flowtext.trim().contains("LL/DL SERVICES SLOT BOOK")) {
						System.out.println("The Next Flow is "+ flowtext);
					//	LL_DL_ServiceSlotbooking();
					} else {
						System.out.println(flowtext + " Applicant Flow is Not Availble");
					}
				} else {
					System.out.println("Flow Exempted");
				}

			} else {
				System.out.println("The Text of Flow is "+text);
			}
		}
		
	}
	}



