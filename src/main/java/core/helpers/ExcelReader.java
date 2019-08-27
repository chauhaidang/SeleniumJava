package core.helpers;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import static core.lucy_kdd_core.TestRunner.bResult;

public class ExcelReader {
    protected String path;
    protected FileInputStream fis = null;
    protected FileOutputStream fileOut = null;
    protected XSSFWorkbook workbook = null;
    protected XSSFSheet sheet = null;
    protected XSSFRow row = null;
    protected XSSFCell cell = null;

    /**
     * Constructor
     * @param _path
     */
    public ExcelReader(String _path){
        this.path = _path;
        //Get excel workbook
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            //Get default sheet: first sheet
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            Log.error("Class: ExcelReader | Constructor | Exception detail: Not able to read the spreadsheet --- \n" + e.getMessage());
            bResult = false;
        }
    }

    /**
     * Get row count
     */
    public int getRowCount(String sheetName){
        try{
            int index = workbook.getSheetIndex(sheetName);
            if(index == -1){
                return 0;
            }
            else{
                sheet = workbook.getSheetAt(index);
            }
            return sheet.getLastRowNum() + 1;
        }
        catch (Exception e){
            Log.error("Class: ExcelReader | Method: getRowCount() | Exception detail: Not able to get row count --- \n" + e.getMessage());
            bResult = false;
            return 0;
        }
    }

    /**
     * Get cell data by column name and row number
     * @param sheetName
     * @param columnName
     * @param rowNum
     * @return
     */
    public String getCellData(String sheetName, String columnName, int rowNum) {
        try {
            if (rowNum <= 0) {
                return "";
            }

            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1; //Pre-defined value to check
            if(index == -1){
                return "";
            }

            //Find column number by column Name
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++){
                if(row.getCell(i).getStringCellValue().trim().equals(columnName)){
                    col_Num = i;
                }
            }
            if(col_Num == -1){
                return "";
            }

            //Find row number
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if(row == null){
                return "";
            }

            //Find Cell
            cell = row.getCell(col_Num);
            if(cell == null){
                return "";
            }

            //Check if cell is string value
            if(cell.getCellType() == cell.CELL_TYPE_STRING){
                return cell.getStringCellValue();
            }
            //Check if cell is numeric or formula
            else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC || cell.getCellType() == cell.CELL_TYPE_FORMULA){
                String cellText = String.valueOf(cell.getNumericCellValue());
                //Check if cell is date formatted
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    //Get year
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
                }

                return cellText;
            }
            //Check if cell is blank
            else if(cell.getCellType() == cell.CELL_TYPE_BLANK){
                return "";
            }
            //Check boolean true false
            else{
                return String.valueOf(cell.getBooleanCellValue());
            }
        }
        catch (Exception e){
            Log.error("Class: ExcelReader | Method: getCellData() | " +
                    "Exception detail: Not able to get data from sheet "+sheetName+", row "+rowNum+", column name "+columnName+" due to ---\n"+e.getMessage());
            bResult = false;
            return "";
        }
    }

    /**
     * Get cell data by column number and row number
     * @param sheetName
     * @param colNum
     * @param rowNum
     * @return
     */
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0) {
                return "";
            }

            int index = workbook.getSheetIndex(sheetName);
            if(index == -1){
                return "";
            }

            //Find row number
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if(row == null){
                return "";
            }

            //Find Cell
            cell = row.getCell(colNum);
            if(cell == null){
                return "";
            }

            //Check if cell is string value
            if(cell.getCellType() == cell.CELL_TYPE_STRING){
                return cell.getStringCellValue();
            }
            //Check if cell is numeric or formula
            else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC || cell.getCellType() == cell.CELL_TYPE_FORMULA){
                String cellText = String.valueOf(cell.getNumericCellValue());
                //Check if cell is date formatted
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    //Get year
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
                }

                return cellText;
            }
            //Check if cell is blank
            else if(cell.getCellType() == cell.CELL_TYPE_BLANK){
                return "";
            }
            //Check boolean true false
            else{
                return String.valueOf(cell.getBooleanCellValue());
            }
        }
        catch (Exception e){
            Log.error("Class: ExcelReader | Method: getCellData() | " +
                    "Exception detail: Not able to get data from sheet "+sheetName+", row "+rowNum+", column name "+colNum+" due to ---\n" + e.getMessage());
            bResult = false;
            return "";
        }
    }

    public int getRowContains(String sheetName, int colNum, String cellVal){
        try{
            int index = workbook.getSheetIndex(sheetName);
            if(index == -1){
                return -1;
            }

            sheet = workbook.getSheetAt(index);
            int rowCount = getRowCount(sheetName);
            int i;
            for(i = 0; i < rowCount; i++){
                if(getCellData(sheetName, colNum, i).equalsIgnoreCase(cellVal)){
                    break;
                }
            }
            return i;
        }
        catch (Exception e){
            Log.error("Class: ExcelReader | Method: getRowContains() | " +
                    "Exception detail: Not able to get rows index that contains value "+ cellVal+ " --- \n" + e.getMessage());
            bResult = false;
            return -1;
        }

    }

    /**
     * Set data to cell
     * @param sheetName
     * @param columnName
     * @param rowNum
     * @param data
     * @return
     */
    public boolean setCellData(String sheetName, String columnName, int rowNum, String data){
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if(rowNum <=0){
                return false;
            }

            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1; //Pre-defined value to check
            if(index == -1){
                return false;
            }

            //get sheet
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++){
                if(row.getCell(i).getStringCellValue().trim().equals(columnName)){
                    col_Num = i;
                }
            }
            if(col_Num == -1){
                return false;
            }

            sheet.autoSizeColumn(col_Num);
            row = sheet.getRow(rowNum -1);
            if(row == null){
                row = sheet.createRow(rowNum - 1);//IF not exist the row. create it then
            }

            cell = row.getCell(col_Num);
            if(cell == null){
                cell = row.createCell(col_Num);
            }

            //Set data to cell
            cell.setCellValue(data);

            //Output stream to the file itself to update
            fileOut = new FileOutputStream(path);
            //Write content to workbook
            workbook.write(fileOut);
            fileOut.close();

            //Re-fetch the workbook
            workbook = new XSSFWorkbook(new FileInputStream(path));
            return true;
        }
        catch (Exception e){
            Log.error("Class: ExcelReader | Method: setCellData() |" +
                    " Exception detail: Not able to set value to cell with column name "+ columnName + " and row " + rowNum + " --- \n "+ e.getMessage());
            bResult = false;
            return false;
        }
    }
}
