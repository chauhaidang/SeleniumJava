package Training.OOP;

public class MethodType {

    static int x = 10;
    static int y = 2;


    public static void main(String[] args){
        sum();
        System.out.println("Value2: " + sum2());
        sum3(5,10);
        System.out.println("Value4: "+ sum4(6,1));
    }

    public static void sum(){
        System.out.println("Value: " + (x+y));
    }

    public static int sum2(){
        return x+y;
    }

    public static void sum3(int x, int y){
        System.out.println("Value 3: " + (x+y));
    }

    public static int sum4(int x, int y){
        return x+y;
    }
}
