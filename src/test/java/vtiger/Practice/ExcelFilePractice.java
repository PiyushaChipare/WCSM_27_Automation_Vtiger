package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//Step 1. Load file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData0.xlsx");
		//Step 2. Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//Step 3. Get control over sheet
		Sheet sheet = wb.getSheet("Organisation");
		//Step 4. Get control over row 
		Row rw = sheet.getRow(0);
		//Step 5. Get control over cell
		Cell cl = rw.getCell(0);
		//Step 6. Read data in cell
		String value = cl.getStringCellValue();
		System.out.println(value);
	}

}
