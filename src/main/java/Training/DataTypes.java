package Training;

public class DataTypes {
    public static void main(String[] arg){
        int i = 1234; //int --> interger. That mean prototype of int is integer
        float f = 1.234f;
        long l = 123456123810328l;
        double d = 1.21313;
        boolean b = true;//Or false
        char c = 'a'; //single quote for character
        String s = "asdasd"; //String is a Class in Java. Double quote for string value

        //Non-primitive data type
        DataTypes dt;

        //Primitive data type
        int i1 = 2;

        //This is declare
        String dang;

        //This is initialization
        String dang2 = "abd";

        //Camel case
        String testCamelCase;

        //String class

        String abc = new String();
        abc = "hello";

        String abc1 = "Hello";

        String s1 = "A";
        String s2 = "Asda";
        String s3 = "qwdnqkjsd";
        String s4 = s1 + s2 + s3;
        System.out.println(s4);

        //Operands (operator syntax)
        //Unary operands --> single operator
        //Binary operands --> two operator
        //Tenary operands --> 3 operator

        System.out.println(!false); // + - * / %

        //Equality and relational
        // == != > < >= <=

        //Conditional Operators
        // && ||
        // ?: -> this is special. It is ternary operator
        System.out.println(true && true);
        System.out.println(false && true);

    }
}
