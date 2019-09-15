package Training.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminationOperationStream {
    /**
     * Once termination operation is executed, stream will stop there. We can distinguish TO and IO by looking at the return type
     * of TO, they are always either void or non-stream type
     */

    public static void main(String[] args) {
        //foreach()
        //collect()
        List a = Stream.of(1, 2, 8, 12, 50, 20, 17).collect(Collectors.toList());
        System.out.println(a);

        //True false condition check: anyMatch(), allMatch(), nonMatch()
        boolean result = Stream.of(1, 2, 8, 12, 50, 20, 17).allMatch(it -> it.equals(1)); // false
        boolean result2 = Stream.of(1, 2, 8, 12, 50, 20, 17).anyMatch(it -> it.equals(1)); //true
        boolean result3 = Stream.of(1, 2, 8, 12, 50, 20, 17).noneMatch(it -> it.equals(1)); //false
        System.out.println("" + result + " " + result2 + " " + result3);

        //count()
        long b = Stream.of(1, 2, 8, 12, 50, 20, 17).count();
        System.out.println(b);

        //get(), max() and min()
        int max = Stream.of(1, 2, 8, 12, 50, 20, 17).max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(max);
        int min = Stream.of(1, 2, 8, 12, 50, 20, 17).min(Comparator.comparing(Integer::intValue)).get();
        System.out.println(min);

        //or using mapToInt() to compare directly
        int max2 = Stream.of(1, 2, 8, 12, 50, 20, 17)
                .mapToInt(it -> it)
                .max()
                .getAsInt();

        //Example min max with object class
        List<Programing> listP = Arrays.asList(
                new Programing("Java", 5),
                new Programing("C++", 10),
                new Programing("C#", 1)
        );
        Programing theMostExpLang = listP.stream()
                .max(Comparator.comparing(Programing::getExp))
                .get();
        System.out.println(theMostExpLang.getLanguage()); // C++

        //summaryStatistic()
        //Work with collection of number
        List<Integer> listNum = Arrays.asList(1, 4, 1, 12, 10);
        IntSummaryStatistics intSummaryStatistics = listNum.stream().mapToInt(it -> it).summaryStatistics();
        System.out.println("MAX IS " + intSummaryStatistics.getMax());
        System.out.println("AVERAGE IS " + intSummaryStatistics.getAverage());
        System.out.println("MIN IS " + intSummaryStatistics.getMin());
        System.out.println("COUNT IS " + intSummaryStatistics.getCount());
        System.out.println("SUM IS " + intSummaryStatistics.getSum());

        //reduce()
        //reduce will combine all element of stream into one by using binary operator
        int resultReduce = IntStream.of(1, 2, 4, 10).reduce(0, (x, y) -> x + y);
        System.out.println(resultReduce);
    }

    static class Programing {
        String language;
        int exp;

        public Programing(String _language, int _exp) {
            language = _language;
            exp = _exp;
        }

        public String getLanguage() {
            return language;
        }

        public int getExp() {
            return exp;
        }
    }
}
