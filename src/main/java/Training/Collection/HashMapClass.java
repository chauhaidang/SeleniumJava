package Training.Collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapClass {
    public static void main(String[] args){
        //hashmap just like a table with 2 column, one is key and other is value
        // entry => key:value

        //Declare
        HashMap hm2 = new HashMap();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        //Adding entry (pair)
        hm.put("label1", 1);
        hm.put("label2", 2);
        hm.put("label3", 3);
        hm.put("label4", 4);
        hm.put("label5", 5);
        System.out.println(hm);

        //Remove an entry from hashmap
        hm.remove("lable1");
        System.out.println("After removing..." + hm);

        //Interact with hashmap entry
        //Each pair element in the hashmap has its type is "map.Entry"
        //hm.entrySet(); // this is a Set of map.Entry element

        for(Map.Entry m: hm.entrySet()){
            System.out.println(m.getKey()+ " has value: "+ m.getValue());
        }
    }
}
