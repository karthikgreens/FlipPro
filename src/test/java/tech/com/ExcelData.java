package tech.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public String getLoginCrendentials() {
		File f = new File("D:\\Studies\\ws-new\\ProNewAllNew\\src\\test\\resources\\Excel\\Book1.xlsx");
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(f);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sh = wb.getSheetAt(0); // wb.getSheet("Sheet1");
		DataFormatter dataFormatter = new DataFormatter();
		String cellContent = "";
		for (Row rows : sh) {
			cellContent = dataFormatter.formatCellValue(rows.getCell(0)) + "-" // Delimiter
					+ dataFormatter.formatCellValue(rows.getCell(1));
		}
		return cellContent;
	}

}
