package core.lucy_kdd_core;

import core.helpers.ExcelReader;
import core.helpers.Log;

import static core.lucy_kdd_core.TestRunner.bResult;

public class ExcelHandler extends ExcelReader {

    ExcelHandler(String path){
        super(path);
    }

    protected int getTestStepsCount(String sheetName, String sTestCaseName, int iTestCaseStart) {
        try{
            int number;
            for (int i = iTestCaseStart; i <= getRowCount(sheetName); i++) {
                if (!sTestCaseName.equals(getCellData(sheetName, Const.TESTCASE_COL, i))) {
                    number = i;
                    return number;
                }
            }
            super.sheet = workbook.getSheet(sheetName);
            number = sheet.getLastRowNum() + 1;
            return number;
        }
        catch (Exception e){
            Log.error("Class: ExcelReader | Method: getTestStepsCount() |" +
                    " Exception detail: Not able to get total test step of case "+ sTestCaseName + " --- \n "+ e.getMessage());
            bResult = false;
            return -1;
        }
    }
}
