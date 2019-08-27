package Training.ExceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionClass2Uncheck {
    public static void main(String[] args) throws InterruptedException, IOException {
        //Thread.sleep(4000);//The compiler will tell you need to fix this exception before execute
        try{
            Thread.sleep(4000);
        }
        catch (InterruptedException e){

        }
        //Or use throws keyword at method level
        Thread.sleep(2000);

        //Need to handle IOException or FileNotFoundException
        FileInputStream fis = new FileInputStream("");
    }
}
