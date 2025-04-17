package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import frameworkLibrary.BaseClass;
import pageobjects.DLsearchPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;

public class Action_214 extends BaseClass {
	WebDriver driver;
	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	

	@Test(invocationCount = 1)
	public void TC_DL_Search() throws IOException {
		
		
		
		stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		
		DLsearchPage dlsearchPage = new DLsearchPage();
		dlsearchPage.Clickon_DLSearch();
		dlsearchPage.Enter_DL_Licno(getdata("DLNumber"));
		dlsearchPage.Enter_Licence_Holder_Name(getdata("HolderName"));
		dlsearchPage.Enter_DateofBirth(getdata("DOB"));
		dlsearchPage.Enter_MobileNo(getdata("PhoneNo"));
	
		
		
	}
}
