package Training.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class IntermediationOperationStream {
    /**
     * It is an operation after stream instance created. But it will be execute right at terminal operation was executed
     */
    public static void main(String[] args) {
        //Sample of filter()
        //Using iterator to generate stream
        Stream.iterate(1, it -> it + 1) // iterate from 1 to infinity
                .filter(it -> it % 3 == 0) // Filter which is modulus to 3
                .limit(6) // Limit result to 6 element
                .forEach(System.out::println);

        //Using skip(), limit() => same meaning with offset limit in Database
        Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);

        //Using map()
        Stream.of("a", "b", "c", "d", "e", "f").map(String::toUpperCase).forEach(System.out::println);

        //Using sorted()
        Stream.of(1, 2, 8, 12, 50, 20, 17).sorted().forEach(System.out::println);
        Stream.of(1, 2, 8, 12, 50, 20, 17)
                .sorted(Comparator.comparing(Integer::intValue))
                .forEach(System.out::println);
        Stream.of(1, 2, 8, 12, 50, 20, 17)
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);


    }
}
