package Training.Stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveTypeStream {
    public static void main(String[] args) {
        IntStream.range(1, 4).forEach(System.out::println);
        DoubleStream.of(1, 2, 3).forEach(System.out::println);
    }
}

