package Training.Collection;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {
    /**
     * Generic will help you to generalize data type of multiple object. It's kind of abstraction.
     */
    public static void main(String[] args){
        List list = new ArrayList(); //List is an interface of ArrayList so we can call like this
        list.add("ABC");
        list.add('A');
        list.add(5);


        //System.out.println(20 + list.get(0)); compile error due to operator between Object and Integer
        // So we try to assign it
        //int a = list.get(0); again will be error due to can not assign object to int variable
        // So we try to cast it
        int a = (Integer)list.get(2); // This okay, but what if the list.get(2) return a string next time? Do again need to cast it to String?
        System.out.println(a + 20);

        //Here is the solution to make arraylist act like a literal array
        List<Integer> list1 = new ArrayList<Integer>();//always store Int
        list1.add(10);
        //list1.add("ABC");// error
        //So now every element in the list will have specific type as Integer not Object
        System.out.println(list1.get(0));
    }
}
