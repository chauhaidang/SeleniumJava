package Training.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NonPrimitiveTypeStream {
    public static void main(String[] args) {
        //With array
        String[] name = {"A", "B", "C", "D", "E"};
        Stream<String> stream = Arrays.stream(name);
        stream.forEach(System.out::println); //The same thing with it-> system.out.println(it);

        //With List
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(7);
        list1.stream().forEach(System.out::println);

        //With Stream generate
        Stream<String> stream1 = Stream.generate(() -> "DANG").limit(5);
        String[] taolao = stream1.toArray(String[]::new);
        System.out.println(Arrays.toString(taolao));

        //With stream iterator
        Stream<Long> stream2 = Stream.iterate(1L, it -> it + 1).limit(5);
        stream2.forEach(System.out::println);

        //With regex pattern delimiter
        String a = "Hello, Dang";
        Pattern.compile(",").splitAsStream(a).forEach(System.out::println);
    }
}
