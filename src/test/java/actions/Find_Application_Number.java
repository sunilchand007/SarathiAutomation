package actions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.FindApplicationNumberPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;

public class Find_Application_Number extends BaseClass{
	WebDriver driver;
	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	@Test(invocationCount = 1)
	public void TC_Find_Application_Number() {
		
		
		stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		FindApplicationNumberPage findApplicationNumberPage = new FindApplicationNumberPage();
		findApplicationNumberPage.Clickon_Find_Application_Number();
		findApplicationNumberPage.Select_State(getdata("State"));
		findApplicationNumberPage.Select_RTO(getdata("RTOCode") + " ");
		findApplicationNumberPage.Enter_FirstName(getdata("FN"));
		findApplicationNumberPage.Enter_LastName(getdata("LN"));
		findApplicationNumberPage.Enter_DateOfBirth(getdata("DOB"));
		findApplicationNumberPage.Clickon_Submit_button();

	}
}
