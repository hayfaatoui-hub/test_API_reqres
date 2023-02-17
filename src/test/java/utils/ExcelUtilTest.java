package utils;

public class ExcelUtilTest {


    public static void main(String[] args) {
        String excelPath = ".Data/DataFile.xlsx";
        String sheetname = "DataFile";

        ExcelUtils excel = new ExcelUtils(excelPath, sheetname);

        excel.getRowCount();
        excel.getCellData(1,0);
        excel.getCellData(1,1);
        excel.getCellData(1,2);
    }
}
