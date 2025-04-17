package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.LLTestAcknowledgementPage;
import pageobjects.LLTestAppointmentDetailsPage;
import pageobjects.LLTestAppointmentDetailsPreviewPage;
import pageobjects.LLTestAppointmentsSlotBookingPage;

public class Action_132 {
   WebDriver driver;
	
   public Action_132(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void LLslotbooking() throws IOException, InterruptedException {
		
		LLTestAppointmentDetailsPage lLTestAppointmentDetails = new LLTestAppointmentDetailsPage(driver);
		lLTestAppointmentDetails.Clickon_ProceedtoBookSlot_Button();
		LLTestAppointmentsSlotBookingPage lLTestAppointmentsSlotBooking = new LLTestAppointmentsSlotBookingPage(driver);
		lLTestAppointmentsSlotBooking.SelectionofDateinSlotBooking();
	
		lLTestAppointmentsSlotBooking.Clickon_Bookslotbutton();
		LLTestAppointmentDetailsPreviewPage lLTestAppointmentDetailsPreview = new LLTestAppointmentDetailsPreviewPage(driver);
		
		lLTestAppointmentDetailsPreview.Clickon_Confirm_slotbookingbutton();
		LLTestAcknowledgementPage lLTestAcknowledgement = new LLTestAcknowledgementPage(driver);
		lLTestAcknowledgement.Clickon_NextinAcknowledgementPage();
	}
}
