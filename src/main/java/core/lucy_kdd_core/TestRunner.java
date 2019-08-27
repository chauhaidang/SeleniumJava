package core.lucy_kdd_core;

import core.helpers.Log;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import static core.lucy_kdd_core.Const.*;

public class TestRunner {
    //Create an object of ActionKeyword class to reference
    public static Properties OR;
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static String sPageObject;
    public static Method[] methods;
    public static boolean bResult=true;

    public static int iTestStep;
    public static int iTestLastStep;
    public static String sTestCaseID;
    public static String sRunMode;

    private static ExcelHandler excel;

    public TestRunner() throws NoSuchMethodException, SecurityException{
        //Init the instance of ActionKeyword class
        actionKeywords = new ActionKeywords();
        //Load all methods from the above class
        methods = actionKeywords.getClass().getMethods();
    }

    public static void main(String[] args) throws Exception {
        //Read excel workbook
        excel = new ExcelHandler(TEST_PATH + "/lucy_kdd_test/keyword_driven_input/DataEngine.xlsx");

        //Declare object repository
        FileInputStream fis = new FileInputStream(PATH_OR);
        OR = new Properties(System.getProperties());

        //Load properties to OR object
        OR.load(fis);

        TestRunner startEngine = new TestRunner();
        startEngine.execute_TestCase();
    }

    private void execute_TestCase() throws Exception {

        //Get total number of test cases
        int iTotalTestCases = excel.getRowCount(TEST_CASES_SHEET);

        //Loop over number of test cases
        for (int iTestCaseRow = 1; iTestCaseRow <= iTotalTestCases; iTestCaseRow++) {
            //Set result to true first for every test case
            bResult = true;

            //Get test case name and run mode value in test case sheet
            sTestCaseID = excel.getCellData(TEST_CASES_SHEET, TESTCASE_COL, iTestCaseRow);
            sRunMode = excel.getCellData(TEST_CASES_SHEET, RUN_MODE_COLUMN, iTestCaseRow);

            //Check run mode
            if (sRunMode.equalsIgnoreCase("Y")) {
                iTestStep = excel.getRowContains(TEST_STEPS_SHEET, TESTCASE_COL, sTestCaseID);
                iTestLastStep = excel.getTestStepsCount(TEST_STEPS_SHEET, sTestCaseID, iTestStep);
                Log.startTestCase(sTestCaseID);
                //Set result to true before every test step
                bResult = true;
                while (iTestStep <= iTestLastStep) {
                    sActionKeyword = excel.getCellData(TEST_STEPS_SHEET, KEYWORD_COLUMN, iTestStep);
                    sPageObject = excel.getCellData(TEST_STEPS_SHEET, OBJECT_COLUMN, iTestStep);
                    executeAction();

                    //This is the result code set for test case, this code will execute after each test step
                    //The execution flow will go in to this only if the value of bResult is 'false'. Mean there is one step failed
                    if(!bResult){
                        //If 'false' then store the test case result as Fail
                        excel.setCellData(TEST_CASES_SHEET,TESTCASE_RESULT, iTestCaseRow, FAIL);
                        //By this break statement, execution flow will not execute any more test step (action) of the failed test case
                        break;
                    }
                    iTestStep++;
                }

                //This will only execute after the last step of the test case, if value is not 'false' at any step. Means the test case passed
                if(bResult){
                    //Storing the result as Pass in the excel sheet
                    excel.setCellData(TEST_CASES_SHEET, TESTCASE_RESULT, iTestCaseRow, PASS);
                }
                Log.endTestCase(sTestCaseID);
            }
        }
    }

    private static void executeAction() throws Exception{
        try {
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals(sActionKeyword)) {
                    methods[i].invoke(actionKeywords, sPageObject);
                    //This code block will execute after every test step
                    if(bResult){
                        //If the executed test step value is true, Pass the test step in Excel sheet
                        excel.setCellData(TEST_STEPS_SHEET, TESTSTEP_RESULT, iTestStep, PASS);
                        break;
                    }else {
                        //If the executed test step value is false, Fail the test step in Excel sheet
                        excel.setCellData(TEST_STEPS_SHEET, TESTSTEP_RESULT, iTestStep, FAIL);
                        //In case of false, the test execution will not reach to last step of closing browser
                        //So it make sense to close the browser before moving on to next test case
                        ActionKeywords.closeBrowser("");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
