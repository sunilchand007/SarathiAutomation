package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;
import pageobjects.Login_DLTestResultsPage;

public class Action_210 extends BasePage{

	Login_DLTestResultsPage Login_DLTestResultsPage;
	WebDriver driver;

	public void RecordDLTestResults() {
		scrooldown(driver);
		Login_DLTestResultsPage = new Login_DLTestResultsPage(driver);
		List<WebElement> Totalcovs = driver.findElements(By.xpath("//table[@id='testresult']/tbody/tr"));
		int size = Totalcovs.size();
		System.out.println("No of COVS :"+size);
		for (int i = 1; i < size; i++) {
			WebElement testreele = driver
					.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td/div/select"));
			Select testresult = new Select(testreele);
			testresult.selectByVisibleText(getdata("TestResult"));
			driver.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[6]/input"))
					.sendKeys("ap05nm888" + i + "");
			driver.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[10]/input[2]"))
					.click();

			WebElement ele = driver
					.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[8]/input"));
			if (ele.getAttribute("value").isEmpty()) {
				ele.sendKeys(GetCurrentDate());
				ele.sendKeys(Keys.ESCAPE);
				WebElement lstopn = driver
						.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[9]/select"));
	
			 String timeslotdropdown = "Y";
				if(timeslotdropdown.equalsIgnoreCase("Y")) {
					
					Select timeslot = new Select(lstopn);
					List<WebElement> op = timeslot.getOptions();
					
						lstopn = driver.findElement(
								By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[9]/select"));
						timeslot = new Select(lstopn);
						op = timeslot.getOptions();
						System.out.println(op.get(1).getText());
						timeslot.selectByVisibleText(op.get(1).getText());
						break;
				}
				else {
					
					System.out.println("no need to select time slot ");

					
				}
				
				
			} else {
				System.out.println("Options are Entered and Selected");
			}
		}
		}
}
