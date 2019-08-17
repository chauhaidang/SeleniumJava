package Training.ArraysAndString;

public class StringClass {
    public static void main(String[] args){
        //String is a collection of character. Java have String class so that we can handle each character of the string.
        //In array Object.length is a getter of length property, not a method
        //But with String, length() is a method: with return number of characters in a string

        /**Java String methods:
         * length(): count number of characters and return it
         *
         * concat(targetString): join another string to the original string and return the whole one
         *
         * trim(): remote all space from the beginning and end of a string and return it
         *
         * charAt(startIndex); return a character of start index
         *
         * contains(charSequence): return true or false according to result of if sequence characters exist in a String
         *
         * equals(String object): return true or false according to the match of two string's characters
         *
         * equalsIgnoreCase(String object): return true or false like equals() but this ignore Case sensitive in Each Char
         *
         * replace(charSequence, charSequence): replace targer char sequence with expected char sequence and return new one
         *
         * subString(startIndex, endIndex): return a new string which is cut from original string from start i to end (i-1)
         *
         * toUpperCase(); return a new String with all character to be in capital
         *
         * toLowerCase(); return a new String with all character to be in normal form
         * */

        String a = " My name is ";
        String b = "Dang ";

        System.out.println(a.length()); // 11 characters

        System.out.println(a.concat(b));

        System.out.println(a.concat(b).trim());

        System.out.println(b.charAt(0));

        System.out.println(b.contains("ang "));
        System.out.println(b.contains(" ang "));

        String obj1 = "Dang";
        String obj2 = "dang";
        System.out.println(obj1.equals(obj2));

        System.out.println(obj1.equalsIgnoreCase(obj2));

        String obj3 = "Welcome";
        System.out.println(obj3.replace("e", "e1"));

        String obj4 = "0123456789";
        System.out.println(obj4.substring(0, 9)); // -> 0 -> (9-1) => 0 1 2 3 4 5 6 7 8
        System.out.println(obj4.substring(4,7)); // -> 4 -> (7-1) => 4 5 6

        String obj5 = "LowerCase";
        System.out.println(obj5.toUpperCase());
        System.out.println(obj5.toLowerCase());

    }
}
