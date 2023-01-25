package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
    Sheet s;
	Workbook wb;

	public Sheet readExcel(String filePath,String fileName,String sheetName) throws InvalidFormatException, IOException {
		
		//fill code here
		
		File f= new File(filePath+"\\"+fileName);
		
		// File f = new File(fileName);
		
		FileInputStream fis= new FileInputStream(f);
		
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet s=wb.getSheet(sheetName);
		return s;
		
		
	}	
}
