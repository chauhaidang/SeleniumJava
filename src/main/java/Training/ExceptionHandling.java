package Training;

public class ExceptionHandling {
    public static void main(String[] args) throws Exception {
        System.out.println("After try catch");
        try{
            int divine = 10/0;
        }
        catch (Throwable t){
            System.out.println("Error occur");
            System.out.println(t.getMessage());
            //t.printStackTrace();
        }
        System.out.println("After try catch");

        try{
            int i[] = new int[4];
            i[5]=1;
        }
        catch (Throwable t){
            //With selenium we can screenshot here
            System.out.println("Error");
            //throw new Exception("Error");
        }

        try{
            System.out.println("Open DB Connection");
            int divine = 10/0;
        }
        catch (Throwable t){
            System.out.println("ERROR!!!");
        }
        finally {
            System.out.println("Close DB Connection");
        }
    }
}
