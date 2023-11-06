package genericUtilities;
import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ExcelUtility implements IAutoConstants{
	Workbook wb;
	@DataProvider(name="data")
	public Object[][] readingdatafromExcel(){
		File f= new File(EXCEL_PATH);
		try {
			wb= WorkbookFactory.create(f);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheet("Sheet1");
		int rowcount=sheet.getPhysicalNumberOfRows();
		int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
//		for(int row=0;row<rowcount;row++){
//			if (sheet.getRow(row).getPhysicalNumberOfCells() > cellcount) {
//				cellcount = sheet.getRow(row).getPhysicalNumberOfCells();
//			}
		Object[][] data=new Object[rowcount][cellcount];
		for(int row=0;row<rowcount;row++){
			Row ActualRow=sheet.getRow(row);
			for(int cell=0;cell<ActualRow.getPhysicalNumberOfCells();cell++){
				data[row][cell]=ActualRow.getCell(cell).toString();
			}
		}
		return data;
	}
	}

