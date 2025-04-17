package actions;

import org.openqa.selenium.WebDriver;

import pageobjects.CL_CLTestResultsPage;

public class Action_142 {

	WebDriver driver;

	public void RecordCLTestResults() {
		CL_CLTestResultsPage CLTestResults = new CL_CLTestResultsPage(driver);
		CLTestResults.Set_TestResult();
		CLTestResults.Set_DateOF_CLTest();
		CLTestResults.ClickonSubmitbutton();
		}
}
