package automate.salesforce;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUserData {

	static String getUserData(String retValue) {
		String sFile = System.getProperty("user.dir") + "/UserData.xls";
		try {

			HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
			HSSFSheet myExcleSheet = myExcelBook.getSheet("login");
			HSSFRow row1 = myExcleSheet.getRow(0);
			if (retValue.contains("user")) {
				System.out.println(row1);
				String userName = row1.getCell(0).getStringCellValue();

				System.out.println(row1.getCell(0).getStringCellValue());
				return userName;
			} else if (retValue.contains("pass")) {
				String password = row1.getCell(1).getStringCellValue();
				System.out.println(row1.getCell(1).getStringCellValue());
				return password;
			} else if (retValue.contains("first")) {
				String firstName = row1.getCell(2).getStringCellValue();
				System.out.println(row1.getCell(2).getStringCellValue());
				return firstName;
			} else if (retValue.contains("last")){
				String lastName = row1.getCell(3).getStringCellValue();
				System.out.println(row1.getCell(3).getStringCellValue());
				return lastName;
			} else {
				String email = row1.getCell(4).getStringCellValue();
				System.out.println(row1.getCell(4).getStringCellValue());
				return email;
			}

		} catch (Exception a) {
			System.out.println("Exception in reading excel" + a);
			return null;
		}
	}

}
