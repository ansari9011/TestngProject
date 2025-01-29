package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility2 {

	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	String path;
	
	public excelUtility2(String path) {
		this.path=path;
		
	}
	
	public int getRowCount(String sheetname) throws IOException {
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
	  int rowcount=  sheet.getLastRowNum();
	  workbook.close();
	  fi.close();
		return rowcount;
		
		
	}
	
	public int getCellCount(String sheetname,int rownum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
	int	cellcount=row.getLastCellNum();
	workbook.close();
	fi.close();
		return cellcount;
		
	}
	public String getCellData(String sheetname,int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		DataFormatter formatter= new DataFormatter();
		String Data;
		try {
		Data=formatter.formatCellValue(cell);
		}catch (Exception e) {
			Data="";
		}
		
		return Data;
	}
	
}
