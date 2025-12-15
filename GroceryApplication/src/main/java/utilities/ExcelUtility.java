package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f;//existing Java Class-to read the excel document(in byte form) present in the path mentioned in line 18
	static XSSFWorkbook w;//reusing existing class
	static XSSFSheet sh;//reusing existing class

	public static String readStringData(int row,int col,String sheet) throws IOException//to read string data
	{
		//		f=new FileInputStream("C:\\Users\\aiswa\\git\\samplerepo\\GroceryApplication\\src\\test\\resources\\test_data.xlsx");

		f=new FileInputStream(Constant.TESTDATA);
		w=new XSSFWorkbook(f);//object created for workbook
		sh=w.getSheet(sheet);//reading that particular sheet data
		XSSFRow r=sh.getRow(row);//to get data from particular row
		XSSFCell c=r.getCell(col);//to get data from particular column
		return c.getStringCellValue();//to get string data value from excel
	}
	public static String readIntegerData(int row,int col,String sheet)throws IOException//to read Integer data
	{
		//f=new FileInputStream("C:\\Users\\aiswa\\git\\samplerepo\\GroceryApplication\\src\\test\\resources\\test_data.xlsx");
		f=new FileInputStream(Constant.TESTDATA);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheet);
		XSSFRow r=sh.getRow(row);
		XSSFCell c=r.getCell(col);
		int val=(int) c.getNumericCellValue();//convert double to int  using typecasting
		return String.valueOf(val);//convert int  to string  using valueOf() method
		//return val;
	}
}