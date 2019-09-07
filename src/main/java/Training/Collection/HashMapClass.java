package Training.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapClass {
    public static void main(String[] args){
        //hashmap just like a table with 2 column, one is key and other is value
        // entry => key:value

        //Declare
        HashMap hm2 = new HashMap();
        HashMap<String, Integer> hm = new HashMap<>();

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
        //Each pair element in the hashmap has its type is "Map.Entry"
        //hm.entrySet(); // this method return a Set of Map.Entry element

        for(Map.Entry m: hm.entrySet()){
            System.out.println(m.getKey()+ " has value: "+ m.getValue());
        }

        //Get value by key
        System.out.println(hm.get("label1"));

        //Return Set of Key in the map
        Set<String> setOfKey = hm.keySet();
        System.out.println(setOfKey);

    }
}
