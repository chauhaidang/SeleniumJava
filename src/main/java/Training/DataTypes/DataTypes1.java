package Training.DataTypes;

public class DataTypes1 {
    public static void main(String[] arg) {

        /**
         * Primitive data type
         */
        int i = 1234; //int --> interger. That mean prototype of int is integer
        float f = 1.234f;
        long l = 123456123810328l;
        double d = 1.21313;
        boolean b = true;//Or false
        char c = 'a'; //single quote for character

        /**
         * Derived data types
         * Array, ArrayList, String, HashMap etc...
         */
        String s = "asdasd"; //String is a Class in Java. Double quote for string value

        /**
         * Non-primitive data type
         */
        DataTypes1 dt;


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
    }
}
