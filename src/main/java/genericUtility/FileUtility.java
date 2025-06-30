package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists all  generic methods related to file operation
 * @author Baniprava swain
 * 
 */

public class FileUtility {
	/**
	 * This method will read data from property file and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
		/**
		 * This method will read String Data from the given row and cell and return
		 * the value to the cellar
		 * @param SheetName
		 * @param rowNo
		 * @param celNo
		 * @return Value
		 * @throws IOException
		 */

	public String readDataFromExcelFile( String SheetName, int rowNo, int celNo) throws IOException {
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\seleniumPr.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value =wb.getSheet(SheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	/**
	 * This method will read numeric data from the excel File
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public double readNumericDataFromExcel(String SheetName, int rowNo, int celNo) throws EncryptedDocumentException, IOException{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\seleniumPr.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		double numValue = wb.getSheet(SheetName).getRow(rowNo).getCell(celNo).getNumericCellValue();
		return numValue ;
		
	}
}
