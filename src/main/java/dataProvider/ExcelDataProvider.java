package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	FileInputStream fis;
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		try {
			fis = new FileInputStream("src/test/resources/TestData.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void getData() {
		int noOfSheets = wb.getNumberOfSheets();
		for (int i=0;i<noOfSheets;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase("SignIn")){
				Iterator<Row> rw = wb.getSheetAt(i).rowIterator();
				while(rw.hasNext()){
					Iterator<Cell> ce= rw.next().cellIterator();
					while(ce.hasNext()) {
						System.out.println(ce.next().getStringCellValue());
					}
				}
				
			}
		}
		
		
		
	}

}
