package Training.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertStreamToOthers {
    public static void main(String[] args) {
        //To List
        Stream<String> stream1 = Stream.of("asd", "asda");
        List<String> list1 = stream1.collect(Collectors.toList());

        System.out.println(list1);

        //To Array
        Stream<String> stream2 = Stream.of("asd", "asda");
        String[] array = stream2.toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }
}
