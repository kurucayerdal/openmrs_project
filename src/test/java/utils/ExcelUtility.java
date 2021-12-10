package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

    public static List<List<String>> getListData(String path, String sheetName, int columnCount) {

        List<List<String>> returnList = new ArrayList<>();
        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (Exception e) {
        }
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {
            // Her okunan satırdaki hücreler rowList e ekleniyor
            List<String> rowList = new ArrayList<>();
            Row row = sheet.getRow(i);

            for (int j = 0; j < columnCount; j++) {
                rowList.add(row.getCell(j).toString());
            }
            // Daha sonra rowList 2 boyutlu List'e ekleniyor.
            returnList.add(rowList);
        }
        return returnList;
    }
}
