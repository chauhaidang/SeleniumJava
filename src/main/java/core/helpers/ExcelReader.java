package core.helpers;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

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

    // returns true if data is set successfully else false
    public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url) {

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;


            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {

                if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
                    colNum = i;
            }

            if (colNum == -1)
                return false;
            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);
            XSSFCreationHelper createHelper = workbook.getCreationHelper();

            //cell style for hyperlinks

            CellStyle hlink_style = workbook.createCellStyle();
            XSSFFont hlink_font = workbook.createFont();
            hlink_font.setUnderline(XSSFFont.U_SINGLE);
            hlink_font.setColor(IndexedColors.BLUE.getIndex());
            hlink_style.setFont(hlink_font);
            //hlink_style.setWrapText(true);

            XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
            link.setAddress(url);
            cell.setHyperlink(link);
            cell.setCellStyle(hlink_style);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);

            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    // returns true if sheet is created successfully else false
    public boolean addSheet(String sheetname) {

        FileOutputStream fileOut;
        try {
            workbook.createSheet(sheetname);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if sheet is removed successfully else false if sheet does not exist
    public boolean removeSheet(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return false;

        FileOutputStream fileOut;
        try {
            workbook.removeSheetAt(index);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if column is created successfully
    public boolean addColumn(String sheetName, String colName) {


        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return false;

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            if (row == null)
                row = sheet.createRow(0);


            if (row.getLastCellNum() == -1)
                cell = row.createCell(0);
            else
                cell = row.createCell(row.getLastCellNum());

            cell.setCellValue(colName);
            cell.setCellStyle(style);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;


    }


    // removes a column and all the contents
    public boolean removeColumn(String sheetName, int colNum) {
        try {
            if (!isSheetExist(sheetName))
                return false;
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
            XSSFCreationHelper createHelper = workbook.getCreationHelper();
            style.setFillPattern(HSSFCellStyle.NO_FILL);


            for (int i = 0; i < getRowCount(sheetName); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cell = row.getCell(colNum);
                    if (cell != null) {
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }


    // find whether sheets exists
    public boolean isSheetExist(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if (index == -1)
                return false;
            else
                return true;
        } else
            return true;
    }


    // returns number of columns in a sheet
    public int getColumnCount(String sheetName) {
        // check if sheet exists
        if (!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if (row == null)
            return -1;

        return row.getLastCellNum();


    }


    //String sheetName, String testCaseName,String keyword ,String URL,String message
    public boolean addHyperLink(String sheetName, String screenShotColName, String testCaseName, int index, String url, String message) {


        url = url.replace('\\', '/');
        if (!isSheetExist(sheetName))
            return false;

        sheet = workbook.getSheet(sheetName);

        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)) {

                setCellData(sheetName, screenShotColName, i + index, message, url);
                break;
            }
        }


        return true;
    }

    public int getCellRowNum(String sheetName, String colName, String cellValue) {

        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
                return i;
            }
        }
        return -1;

    }
}
