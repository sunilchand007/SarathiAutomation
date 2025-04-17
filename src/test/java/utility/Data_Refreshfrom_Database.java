package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import javax.naming.Context;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class Data_Refreshfrom_Database extends BasePage {

	WebDriver driver;
	boolean stepstatus;
	Properties prop;
	public Data_Refreshfrom_Database(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ConnectDB(String selectDB , String DBQuery, String FileName, String Sheetname)
			throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println("Inside datarfreshfrom database connect db method ");
		try {
			System.out.println("Connecting to Database..." + "\n" + df.format(new Date()) + ""+ "\n-----------------------------------------------------------------------------");
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(selectDB, "readonly", "readonly");
			System.out.println("Connected to Database");
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Failed to connect to DB");
			ex.printStackTrace();
		}

		if (conn != null) {

			PreparedStatement ps = conn.prepareStatement(DBQuery);
			rs = ps.executeQuery();
			System.out.println("Resultset of the query" +   rs);
			WriteToExcel(rs, "Database\\" + FileName + ".xlsx", Sheetname);
			System.out.println(
					"Created and fetched data to excel sheet.Please refresh your workspace and check in Database folder."
							+ "\n" + df.format(new Date()) + ""
							+ "\n-----------------------------------------------------------------------------");
			conn.close();
			System.out.println("Disconnected from Database..." + "\n" + df.format(new Date()) + ""
					+ "\n-----------------------------------------------------------------------------");
		}
	}
	
	public void loaddata() throws IOException {
		FileReader reader = new FileReader("DataFiles\\Application.properties");
		prop = new Properties();
		prop.load(reader);

	}

	private void WriteToExcel(ResultSet rs, String FileName, String SheetName) throws SQLException, IOException {
		meta = rs.getMetaData();
		List<String> columns = new ArrayList<String>();
		for (int i = 1; i <= meta.getColumnCount(); i++) {
			columns.add(meta.getColumnLabel(i));
		}

		try (Workbook book = new XSSFWorkbook()) {

			Sheet sheet = book.createSheet(SheetName);
			Row header = sheet.createRow(0);
			for (int i = 0; i < columns.size(); i++) {
				header.createCell(i).setCellValue(columns.get(i));
			}
			int rowindex = 0;
			while (rs.next()) {
				Row row = sheet.createRow(++rowindex);
				for (int i = 0; i < columns.size(); i++) {
					Cell cell = row.createCell(i);
					String val = Objects.toString(rs.getObject(columns.get(i)), "");
					cell.setCellValue(val);
				}
			}
			try (FileOutputStream fos = new FileOutputStream(FileName)) {

				book.write(fos);
				fos.close();
				book.close();

			}
		}

	}
	
	

}
