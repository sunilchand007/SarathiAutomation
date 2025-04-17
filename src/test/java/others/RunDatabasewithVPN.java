package others;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import frameworkLibrary.BaseClass;
import utility.Utilitymethods;

public class RunDatabasewithVPN extends BaseClass {
	WebDriver driver;

	@Test()
	public void DataRefresh() throws ClassNotFoundException, SQLException, IOException {
	//	Data_Refreshfrom_Database db = new Data_Refreshfrom_Database(driver);
		//String dburl = prop.getProperty("DatabaseURL");
		//System.out.println(dburl);
	//	db.ConnectDB("jdbc:postgresql://10.246.82.161:5432/sow4stg",getdata("UserQuery"), getdata("UserDesiredFileName"), getdata("UserdesiredSheetName"));
	//	setdata("Status", "Pass");
		
		
		//connecting to state customization excel (ekyc_impl_states) to get the value of 'ekyc_is_rto_code' 
		/* ConnecttoExcel(prop.getProperty("ekyc_is_rto_code"), prop.getProperty("ekyc_impl_states"));
		 String value_of_ekyc_is_rto_code = outcome;
		 System.out.println(value_of_ekyc_is_rto_code);
		 */
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		//String state = getdata("State");
		String query = "select * from s4_custom_st where st_code = 'AP'";
;
		String columnvalue = "appl_adhar_authenticate_reqd"; 
		String db = "jdbc:postgresql://10.246.82.161:5432/s4s5_preprod";
		utilitymethods.ConnectDBandGetDBvalue(query, columnvalue , db);
	

		
	}

}