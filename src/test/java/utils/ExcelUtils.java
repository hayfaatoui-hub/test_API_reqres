package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    /******constractor*********/
    public ExcelUtils(String excelPath, String xlsxFile){
        try {
            workbook = new XSSFWorkbook(excelPath);
            /* * HSSF for xls files **/
            sheet =  workbook.getSheet(xlsxFile);
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }


    /*public static void main(String[] args){
        getRowCount();
        getCellData();
    }*/

    public static void getCellData(int row, int cell){
        //String value = sheet.getRow(1).getCell(0).getStringCellValue();
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(row).getCell(cell));
        System.out.println(value);
    }

    public static void getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("number of Rows: "+rowCount);
    }
}
