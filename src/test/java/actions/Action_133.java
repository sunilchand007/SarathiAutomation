package actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.ApplicationStatusStage01Page;
import pageobjects.NewDLSlotBookingPageOLD;

public class Action_133 extends BasePage{
	WebDriver driver;
	NewDLSlotBookingPageOLD NewDLSlotBookingPageOLD;
	ApplicationStatusStage01Page applicationStatusstage01;
	Action_215 action_215;
	public void DLSlotbooking() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		NewDLSlotBookingPageOLD = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBookingPageOLD.Clickon_Proceed_Button();

		
		

		
//		driver.findElement(By.xpath("//*[@id='calview']/div[2]/table/tbody/tr[4]/td[6]/a")).click();
		//*[@id="calview"]/div[2]/table/tbody/tr[4]/td[4]/a
		//*[@id="calview"]/div[2]/table/tbody/tr[4]/td[6]
//		wait(5);
		//driver.findElement(By.xpath("//input[@id='MCWG0']")).click();
	//	driver.findElement(By.xpath("//input[@id='LMV1']")).click();
//		driver.findElement(By.xpath("//*[@id='MCWG, LMV2']")).click();
	
	//	NewDLSlotBookingPage.Booking_Slot();

		
		driver.findElement(By.xpath("//*[@id='calview']/div[2]/table/tbody/tr[4]/td[6]/a")).click();
		//*[@id="calview"]/div[2]/table/tbody/tr[4]/td[4]/a
		//*[@id="calview"]/div[2]/table/tbody/tr[4]/td[6]
		wait(5);
		//driver.findElement(By.xpath("//input[@id='MCWG0']")).click();
	//	driver.findElement(By.xpath("//input[@id='LMV1']")).click();
		driver.findElement(By.xpath("//*[@id='MCWG, LMV2']")).click();
	
	//	NewDLSlotBookingPage.Booking_Slot();

		NewDLSlotBookingPageOLD.Booking_Slot();

//		NewDLSlotBookingPage.Clickon_Bookslotbutton();
//		NewDLSlotBookingPage.Clickon_Confirm_slotbookingbutton();
		driver.findElement(By.xpath("//a[text() = 'SarathiOnWeb']")).click();
		applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
	    applicationStatusstage01.enterdetails_In_Applicationstaus();
		
		//NewDLSlotBookingPage.Clickon_Next();
	}
	
	
	public void LL_DL_ServiceSlotbooking() throws IOException {
		NewDLSlotBookingPageOLD = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBookingPageOLD.Clickon_ProceedforDLServices();
		NewDLSlotBookingPageOLD.Booking_SlotforDLServices();
		NewDLSlotBookingPageOLD.Clickon_Bookslotbutton();
		NewDLSlotBookingPageOLD.Clickon_Confirm_slotbookingforDLService();
		NewDLSlotBookingPageOLD.Clickon_Next();
	}
}
