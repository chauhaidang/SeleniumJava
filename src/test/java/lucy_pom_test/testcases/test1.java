package lucy_pom_test.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

public class test1 {

    @Test
    public void testcase01(){
        System.out.println("Run test 1");
    }

    @Test
    public void testcase02(){
        Assert.fail();
    }
}
