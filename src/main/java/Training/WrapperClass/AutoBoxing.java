package Training.WrapperClass;

public class AutoBoxing {

    public static void main(String[] args){
        int a = 10;
        Integer obj = new Integer(a); //Auto-Boxing (wrap a to make it become an object

        int b = obj; //Unboxing (un-wrap to make object become an primitive type variable

        System.out.println(obj);
    }
}
