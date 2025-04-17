package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BaseClass;
import pageobjects.DLtest_sheet_ReportPage;
import pageobjects.StateSpecificHomePage;

public class DrivingLicenceTestSheet extends BaseClass {
	WebDriver driver;
	public void Menuitem_Driving_Licence_Test_Sheet() {
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.clickon_PrintDrivingLicence();
		stateSpecificHomePage.clickon_DrivingLicenceSheet();
		DLtest_sheet_ReportPage dltest_sheet_ReportPage = new DLtest_sheet_ReportPage();
		dltest_sheet_ReportPage.Enter_DrivingLicenceTestSheet_ApplicationNo(getdata("AppNo"));
		dltest_sheet_ReportPage.Enter_DrivingLicenceTestSheetdob(getdata("DOB"));
		dltest_sheet_ReportPage.Clickon_DrivingLicenceTestSheet_Submit();
		wait(2);
		
	}
	
	
}
