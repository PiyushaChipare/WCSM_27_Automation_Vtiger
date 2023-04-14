 package vtiger.GeneralUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to Excel files
 * @author Piyusha Chipare
 *
 */
public class ExcelFileUtility 
{
	/**
	 * This method is used to read cell value from the sheet
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		wb.close(); 
		return value;
	}
	
	/**
	 * This method is used to write data into excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataInExcelFile(String sheetName,int rowIndex,int cellIndex,String value) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		sheet.createRow(rowIndex).createCell(cellIndex).setCellValue(value);	
		
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}

}
