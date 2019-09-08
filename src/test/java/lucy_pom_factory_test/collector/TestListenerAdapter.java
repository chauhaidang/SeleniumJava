package lucy_pom_factory_test.collector;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.util.List;

public class TestListenerAdapter implements IInvokedMethodListener {


    public void afterInvocation(IInvokedMethod method, ITestResult result) {


        Reporter.setCurrentTestResult(result);

        if (method.isTestMethod()) {

            List<Throwable> listThrowableMessages = ErrorCollector.getThrowableMessages();

            //if there are verification failures after running a test method (get this form ErrorCollector)
            if (listThrowableMessages.size() > 0) {

                //set the test method to failed
                result.setStatus(ITestResult.FAILURE);

                //if there is an assertion failure (total throwable object count) add it to verificationFailures
                if (result.getThrowable() != null) {
                    listThrowableMessages.add(result.getThrowable());
                }

                int size = listThrowableMessages.size();
                //if there's only one failure just set that
                if (size == 1) {
                    result.setThrowable(listThrowableMessages.get(0));
                } else {
                    //Then create a customized failure message with all failures and stack traces (except last failure)
                    StringBuilder failureMessage = new StringBuilder("There are (").append(size).append(") failures:\n\n");
                    for (int i = 0; i < size - 1; i++) {
                        failureMessage.append("Failure ").append(i + 1).append(" of ").append(size).append(":\n");
                        Throwable t = listThrowableMessages.get(i);
                        String fullStackTrace = Utils.shortStackTrace(t, false);
                        failureMessage.append(fullStackTrace).append("\n\n");
                    }

                    //final failure - without full stack to make report more shorter
                    Throwable last = listThrowableMessages.get(size - 1);
                    failureMessage.append("Failure ").append(size).append(" of ").append(size).append(":\n");
                    failureMessage.append(last.toString());

                    //Then merge them all together
                    Throwable merged = new Throwable(failureMessage.toString());

                    //From here we can have all throwable message to report
                    //But still need to add shortcut to extend full stack for the last throwable, right?
                    merged.setStackTrace(last.getStackTrace());

                    //Set all failure message to the method results, so it can be throw in console and reportNG
                    result.setThrowable(merged);
                }
            }
        }

    }

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
    }

}
