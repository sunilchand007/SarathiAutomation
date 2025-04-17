package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjects.DLPrintpage;

public class Action_120 {

	WebDriver driver;
	DLPrintpage DLPrint;
	
	public void DLPrint() {
		DLPrint = new DLPrintpage(driver);

		if (driver.getPageSource()
				.contains("You do not have permission to view this page or perform this action") == false) {
			DLPrint.ClickonPaperCard();
			DLPrint.ClickonTodaysDate();
			DLPrint.ClickonYes();
			DLPrint.ClickonSubmit();
			DLPrint.Clickon_PrintALL();
			DLPrint.ClickonProceed();
		} else {
			driver.findElement(By.xpath("//span[text()='HOME']")).click();
			driver.quit();
		}

	}
	
}
