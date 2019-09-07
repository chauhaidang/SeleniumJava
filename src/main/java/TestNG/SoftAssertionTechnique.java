package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTechnique {
    /**
     * Soft assertion will help you to continue to run test even there is failure at some point
     * And it also help you to print bunch of failure at the end
     */
    @Test
    public void validate02() {
        String expected = "Dang";
        String actual = "Chau";
        Assert.assertEquals(actual, expected); // fail and stop immediately here, code below will stop

        //Following file will not be execute due to above failure
        int a = 2;
        int b = 4;
        Assert.assertEquals(a, b);
    }

    @Test
    public void softAssertApplySimple() {
        String expected = "Dang";
        String actual = "Chau";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected); // fail but NOT STOP immediately here, code below will still running

        int a = 2;
        int b = 4;
        softAssert.assertEquals(a, b);
        //But the test now passed while it should not be

    }

    @Test
    public void softAssertApplyAndThrowError() {
        String expected = "Dang";
        String actual = "Chau";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected); // fail but NOT STOP immediately here, code below will still running

        int a = 2;
        int b = 4;
        softAssert.assertEquals(a, b);
        softAssert.assertAll(); //Make it fail the test if there is true error
    }
}
