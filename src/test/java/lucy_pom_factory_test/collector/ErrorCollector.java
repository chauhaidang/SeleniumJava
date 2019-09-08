package lucy_pom_factory_test.collector;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.helpers.Log.error;

public class ErrorCollector {
    private static Map<ITestResult, List<Throwable>> throwableMessageMap = new HashMap<ITestResult, List<Throwable>>();

    public static void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition) {
        Assert.assertFalse(condition);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public static void assertEquals(boolean actual, boolean expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Object[] actual, Object[] expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void verifyTrue(boolean condition) {
        try {
            assertTrue(condition);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }

    public static void verifyTrue(boolean condition, String message) {
        try {
            assertTrue(condition, message);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }

    public static void verifyFalse(boolean condition) {
        try {
            assertFalse(condition);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }

    public static void verifyFalse(boolean condition, String message) {
        try {
            assertFalse(condition, message);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }

    public static void verifyEquals(boolean actual, boolean expected) {
        try {
            assertEquals(actual, expected);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }

    public static void verifyEquals(String actual, String expected) {
        try {
            assertEquals(actual, expected);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }


    public static void verifyEquals(int actual, int expected) throws IOException {
        try {
            assertEquals(actual, expected);
        } catch (Throwable e) {
            error("Verification failed due to:\n" + Utils.shortStackTrace(e, false));
//
//            //TestNG Report and ReportNG
//            System.setProperty("org.uncommons.reportng.escape-output", "false");
//            Utilities.captureScreenshot();
//            Reporter.log("<a target=\"_blank\" href="+ Utilities.fileName+">Screenshot link</a>");
//            Reporter.log("<br>");
//            Reporter.log("<a target=\"_blank\" href="+Utilities.fileName+"><img src="+Utilities.fileName+" height=200 width=200></a>");
//
//            //ExtentReport
//            test.log(LogStatus.FAIL, " FAILED POINT! \n");
//            test.log(LogStatus.INFO, test.addScreenCapture(Utilities.fileName)); //This should not be a failure but information

            addThrowableMessages(e);
        }
    }

    public static void verifyEquals(Object actual, Object expected) {
        try {
            assertEquals(actual, expected);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }

    public static void verifyEquals(Object[] actual, Object[] expected) {
        try {
            assertEquals(actual, expected);
        } catch (Throwable e) {
            addThrowableMessages(e);
        }
    }

    public static void fail(String message) {
        Assert.fail(message);
    }

    public static List<Throwable> getThrowableMessages() {
        List<Throwable> listThrowableMessages = throwableMessageMap.get(Reporter.getCurrentTestResult());
        return listThrowableMessages == null ? new ArrayList<Throwable>() : listThrowableMessages;
    }

    public static void addThrowableMessages(Throwable e) {
        List<Throwable> listThrowableMessages = getThrowableMessages();
        //Update the throwableMessageMap by put to the same key
        throwableMessageMap.put(Reporter.getCurrentTestResult(), listThrowableMessages);
        listThrowableMessages.add(e);
    }

}
