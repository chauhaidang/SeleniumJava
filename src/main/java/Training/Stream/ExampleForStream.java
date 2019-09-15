package Training.Stream;

import java.util.Arrays;
import java.util.List;

public class ExampleForStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 9, 12, 4, 7, 10);


        //Without stream api
        int count = 0;
        for (int element : list) {
            if (element % 2 == 0) {
                count++;
            }
        }

        System.out.println("Number of even number in the list is: " + count);

        //With stream api
        long count2;
        count2 = list.stream().filter(it -> it % 2 == 0).count();
        System.out.println("Number of even number in the list is: " + count);
    }
}
