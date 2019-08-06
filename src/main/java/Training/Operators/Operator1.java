package Training.Operators;

import static Training.JavaDoesNotSupportPassByValue4Static.a;

public class Operator1 {
    public static void main(String[] args){
        /**
         * Arithmetic operators -> + - * / %
         * Relational Operator (Comparation) -> == < > <= >= !=
         * logical operators -> && || !
         * increment/decrement operators -> ++ --
         * assignment operator -> =
         * Ternary operator -> ?:
         */

        //Arithmetic operators
        int a = 10, b = 20;
        System.out.println("Sum " + (a + b));
        System.out.println("Diff "+ (b - a));
        System.out.println("Multiply "+ (a * b));
        System.out.println("Division "+ (a / b));
        System.out.println("Modulus Division "+ (a % b));

        //Relational Operator (Comparation) | Always return boolean value
        System.out.println(a == b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a != b);

        //Logical operators. Work between two boolean value and always return true or false
        boolean x = true;
        boolean y = false;
        System.out.println(x && y);
        System.out.println(x || y);
        System.out.println(!x);
        System.out.println(!y);

        //Increment/decrement operators
        a = 10;
        a++; // a=a+1
        System.out.println(a);

        a = 10;
        a--; // a=a-1
        System.out.println(a);

        //Swap number
        a = 10;
        b = 20;

        System.out.println("Before swap " + a + " " + b);

        int tmp;
        tmp = a;
        a = b;
        b = tmp;

        System.out.println("After swap " + a + " " + b);
    }
}
