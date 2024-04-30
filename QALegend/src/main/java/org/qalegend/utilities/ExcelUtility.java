package org.qalegend.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qalegend.contants.Contants;


public class ExcelUtility {
	 static FileInputStream f;//file read
	  static XSSFWorkbook w;//workbook read
	  static XSSFSheet s;//sheet read
		

	
	  public static String readStringData(int row, int column, String sheetname) {
		   try { f = new FileInputStream(Contants.TEST_DATA_EXCELPATH);
		    w = new XSSFWorkbook(f);
		    s = w.getSheet(sheetname);
		    Row r = s.getRow(row);
		    Cell c = r.getCell(column);
		    if (c != null) {
		        return c.getStringCellValue();
		    } else {
		        return ""; 
		    }
		    }
		    catch(Exception e) {
				throw new RuntimeException("TestData excel not fount");
				
			}

		}

	
	  public static String readIntegerData(int row, int column, String sheetname)  {
		    try{f = new FileInputStream(Contants.TEST_DATA_EXCELPATH);
		    w = new XSSFWorkbook(f);
		    s = w.getSheet(sheetname);
		    Row r = s.getRow(row);
		    Cell c = r.getCell(column);

		    if (c != null && c.getCellType() == CellType.NUMERIC) {
		        int d = (int) c.getNumericCellValue();
		        return String.valueOf(d);
		    } else {
		        return ""; 
		    }
	  }
	    catch(Exception e) {
			throw new RuntimeException("TestData excel not fount");
			
		}
		}

	 


}
