package Training.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetClass {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<String>();
        hs.add("ABC");
        hs.add("Lucy");
        hs.add("AMVNN12");
        hs.add("Lucy");
        hs.add("HEYmansW");

        //Now try to print it to see what is different from List/ArrayList
        System.out.println(hs);
        //As a result,
        //1. we can see the result return does not in order. Now says Set is actually an inorder List, Ok?
        //2. Set does not allow duplicate value when List does. It will automatically remove the duplicate one

        //In selenium, getWindowHandles() actually return a Set to make sure there is no duplicated id session

        //Another way to declare a HashSet with its interface
        Set<String> set = new HashSet<String>();
        set.add("ABC");
        set.add("Lucy");
        set.add("AMVNN12");
        set.add("Lucy");
        set.add("HEYmansW");

        //set.get(1); //HashSet does not have any method to get
        for(String val: set){
            System.out.println(val);
        }

        //Or Iterator
        System.out.println("Iterator......");
        Iterator<String> itr = set.iterator(); //return iterator of the HashSet
        while (itr.hasNext()){
            String obj = itr.next(); //Remember every time we call next(), it will jump to the next iterator
            if(obj.equals("Lucy"))
                System.out.println(obj);

//            if(itr.next().equals("Lucy")){
//                System.out.println(itr.next()); //It will print the next iterator not the current
//            }
        }
    }
}
