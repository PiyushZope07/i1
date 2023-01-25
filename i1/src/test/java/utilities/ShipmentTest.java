package utilities;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

public class ShipmentTest {
	String[][] data;
	ReadExcel readex =new ReadExcel();
	public static Sheet sh;
	
	
	public String[][] getData() throws InvalidFormatException, IOException {
	String filePath="D:\\IRCTC EXCEL DATA";
	String fileName="Flight.xlsx";
	String sheetName="Sheet1";
	
	sh=readex.readExcel(filePath, fileName, sheetName);
	
	int rows= sh.getLastRowNum();
	int cols=sh.getRow(0).getLastCellNum();
	
	
	
	String [][] data = new String [rows][cols];
	DataFormatter df= new DataFormatter();
	for(int i=0	;i<rows;i++) {
	for(int j=0;j<cols;j++) {
	data[i][j]= df.formatCellValue(sh.getRow(i+1).getCell(j));
	}
	
	}
	System.out.println(Arrays.deepToString(data));
	return data;
}
	
}
