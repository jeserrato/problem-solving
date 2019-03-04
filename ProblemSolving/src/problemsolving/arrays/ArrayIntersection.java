package problemsolving.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author jesus_serrato
 */
public class ArrayIntersection {


    public static Set<Integer> findRepeated(int[] array1, int[] array2) {
        final Set<Integer> nonRepeated = new HashSet<>();
        final Set<Integer> repeated = new HashSet<>();

        Stream.concat(Arrays.stream(array1).boxed(), Arrays.stream(array2).boxed())
              .forEach(number -> {
                  boolean inserted = nonRepeated.add(number);

                  if (!inserted) {
                      repeated.add(number);
                  }
              });

        return repeated;
    }

    public static void main(String[] args) {
        int[] array1 = new int[] { 1, 2, 3, 5, 6, 7 };
        int[] array2 = new int[] { 1, 3, 5, 8, 9 };

        findRepeated(array1, array2).stream().forEach(System.out::println);
    }
}
