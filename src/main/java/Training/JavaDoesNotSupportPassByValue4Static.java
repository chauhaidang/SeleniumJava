package Training;

public class JavaDoesNotSupportPassByValue4Static {

    public static int a;
    public static int b;

    public int x;
    public int y;

    public static void swap(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void swap(JavaDoesNotSupportPassByValue4Static obj){
        int tmp = obj.x;
        obj.x = obj.y;
        obj.y = tmp;

    }

    public static void main(String[] args){

        a = 5;
        b = 10;

        swap(a,b); //a and b still remain their values

        System.out.println(""+a);
        System.out.println(""+b);

        JavaDoesNotSupportPassByValue4Static obj = new JavaDoesNotSupportPassByValue4Static();

        obj.x = 5;
        obj.y = 10;

        swap(obj); // this will swap

        System.out.println(""+obj.x);
        System.out.println(""+obj.y);


    }

}
