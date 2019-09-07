package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionAndReportingFailure {

    @Test
    public void validate() {
        String expected = "DANG";
        String actual = "CHAU";

        Assert.assertEquals(expected, actual); //This will fail and stop the build and we don't want that impact another step in test method
    }
}
