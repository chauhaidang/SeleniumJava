package Training.ExceptionHandling;

public class ExceptionClass {

    /**
     * There are 2 type of exceptions
     * Checked: identify by the compiler
     * - Interrupted Exception, IOException, FileNotFoundException, etc.
     *
     * Unchecked: exception which are not checked/identified by compiler
     * - ArithmeticExceptio, NullPointerException, NumberFormatException, IndexOutOfBoundException
     *
     * @param args
     */

    public static void main(String[] args){
        /**
         * Unchecked
         */
        /**
         * Note: 1 try block can have multiple catch block
         */
        try{
            //ArithmeticException
            int a = 50;
            System.out.println(a/0); //This exception can not be catched by compiler
        }
        catch (Exception e){
            e.printStackTrace(); //print error trace but not terminate the flow
        }

        try{
            //NullpointerException
            String b = null;
            System.out.println(b.length());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            //NumberFormatException
            String a = "123a";
            int x = Integer.parseInt(a);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            //IndexOutOfBoundException
            int[] arr = new int[5];
            arr[0] = 20;//this is ok
            arr[10] = 30; //This will cause exception cuz there is no memory area for element with index 10

        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Try catch finally

        try{
            System.out.println("start statement");
            int a = 100/0;
        }
        catch (NullPointerException e){ //if the catcher does not match with specific exception, it still throw error
            System.out.println("go into catch block");
        }
        finally {
            //this block is always execute no matter if exception is thrown or not
            System.out.println("go into finally block");
        }
        System.out.println("program exit");
    }
}
