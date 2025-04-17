package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLTestAppointmentsSlotBookingPage extends BasePage {
	WebDriver driver;
	
	boolean stepstatus;
	
	public LLTestAppointmentsSlotBookingPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//button[@id='slotbtn']")
	WebElement Bookslot;
	@FindBy(how = How.XPATH, using = "//button[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbook;
//	LLTestAppointmentSlotBooking
	
	public void SelectionofDateinSlotBooking() {
		List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']"));
		int TotalAvailbleGreenColorDates = GreenColorDates.size();
		System.out.println("Available Dates: " + TotalAvailbleGreenColorDates);
		WebElement TotalGreenColorDates;
		String Datestext;
		List<WebElement> Timeslots;
		int timeslots;
		WebElement eletimeslot;
		String timeslottxt;
		WebElement seatslabel;
		String seatstxt;
		if (TotalAvailbleGreenColorDates == 1) {
			System.out.println("Last Working day of the month");
			wait(1);
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']"));
		
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();

			Timeslots = driver.findElements(By.xpath(
					"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				Timeslots = driver.findElements(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr/td[1]"));
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr[" + 1
								+ "+" + j + "]/td[2]/label"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(By.xpath(
							"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
									+ 1 + "+" + j + "]/td[2]/input"))
							.click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);

				}
			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					driver.findElement(By.xpath("//a[normalize-space(text())='Next']")).click();
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']"));
						

						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int k = 0; k < timeslots; k++) {
							eletimeslot = Timeslots.get(k);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath(
									"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
											+ 1 + "+" + k + "]/td[2]/label"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
								driver.findElement(By.xpath(
										"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["+ 1 + "+" + k + "]/td[2]/input")).click();

								break outerloop;
							} else {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
							}

						}

					}
				} else {
					System.out.println("Processing your Slot booking");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
				GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']/a"));
				TotalGreenColorDates = GreenColorDates.get(i);
				Datestext = TotalGreenColorDates.getText();
				System.out.println(Datestext);
				GreenColorDates.get(i).click();
				//this is previous xpath 
//				Timeslots = driver.findElements(By.xpath(
//						"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr/td[1]"));
				Timeslots = driver.findElements(By.xpath("//input[@name = 'timeForDisp']"));
				timeslots = Timeslots.size();
				System.out.println(timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(By.xpath(
							"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
								+ 1 + "+" + j + "]/td[2]/label"));
					
					
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
						driver.findElement(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
										+ 1 + "+" + j + "]/td[2]/input"))
								.click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					}

				}

			}

		}
	}

	public void Clickon_Bookslotbutton() {
		stepstatus = clickElement(Bookslot);
		reportEvent(stepstatus, "Able to click Bookslotbutton", "Unable to  click Bookslotbutton", driver, true);

	}
	

		
		
		

}
