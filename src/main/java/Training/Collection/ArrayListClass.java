package Training.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListClass {

    int a[] = new int[5];// fix length, and can not contains multiple data type with in

    public static void main(String[] args){
        //Declaration
        ArrayList list = new ArrayList(); //Can store any type of element

        ArrayList<String> list2 = new ArrayList<String>(); //string

        list.add("avc");
        list.add("avc1");
        list.add("avc2");
        System.out.println(String.join("\n", list));

        //Size of arraylist
        System.out.println(list.size());

        //Remove element from arraylist
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("a");
        list3.add("a1");
        list3.add("a2");
        list3.remove("a1");
        System.out.println(String.join("\n", list3));

        //inserting a new element into arraylist
        list3.add(1, "a1");
        System.out.println(String.join("\n", list3));

        //Iterate all values
        for(String s : list3){
            System.out.println(s);
        }

        //storage multiple type of value
        ArrayList list4 = new ArrayList();
        list4.add("ABC");
        list4.add('F');
        list4.add(4);

        System.out.println("DATA "+ list4);
        for(Object o : list4){
            System.out.println(o.toString());
        }

        //Using Iterator Interface
        ArrayList list5 = new ArrayList();
        list5.add("TOTO1");
        list5.add("AC");
        list5.add("TOTO1");
        System.out.println("Iterator with array list.........");
        Iterator iterator = list5.iterator(); //Iterator will iterate the list without need to know how many index it have
        //Best practice is to use while loop
        while(iterator.hasNext()){
            System.out.println(iterator.next()); // next() return the next element
        }
    }

}
