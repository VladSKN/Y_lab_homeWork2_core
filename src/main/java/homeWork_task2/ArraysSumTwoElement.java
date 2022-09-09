package homeWork_task2;

/*
Task2

    [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysSumTwoElement {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 7};
        System.out.println(Arrays.toString(twoSum(array, 10)));
        System.out.println(Arrays.toString(twoSumStream(array, 10)));
        System.out.println(Arrays.toString(twoSumMap(array, 10)));
    }

    /**
     * В данной реализации выбран Stream
     * Если в массиве нет пары чисел которые в сумме дают число sum
     * возвращается [0, 0]
     */
    private static int[] twoSumStream(int[] array, int sum) {
        int[] result = new int[2];
        Arrays.stream(array)
                .forEach(el1 -> Arrays.stream(array).filter(el2 -> el2 + el1 == sum)
                        .forEach(found -> {
                            result[0] = found;
                            result[1] = el1;
                        }));
        return result;
    }

    /**
     * Решение методом двух указателей
     * сам алгоритм двух указателей работает за O(n) однако работает он на отсортированных массивах
     * сложность Arrays.sort O(nlogn) в соответствии с javadoc метода
     * Если в массиве нет пары чисел которые в сумме дают число sum
     * возвращается [0, 0]
     */
    private static int[] twoSum(int[] input, int targetValue) {
        Arrays.sort(input);
        int[] result = new int[2];
        int pointerOne = 0;
        int pointerTwo = input.length - 1;

        while (pointerOne < pointerTwo) {
            int sum = input[pointerOne] + input[pointerTwo];

            if (sum == targetValue) {
                result[0] = input[pointerOne];
                result[1] = input[pointerTwo];
                return result;
            } else if (sum < targetValue) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }
        return result;
    }

    /**
     * Если в массиве нет пары чисел которые в сумме дают число sum
     * возвращается [0, 0]
     * в данном решении использовал алгорим на основе Map
     * сложность O(n)
     */
    private static int[] twoSumMap(int[] input, int targetValue) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], i);
        }

        for (int i = 0; i < input.length; i++) {
            int result = targetValue - input[i];
            Integer j = map.get(result);
            if (j != null && i != j) {
                return new int[]{input[i], input[j]};
            }
        }
        return new int[]{0, 0};
    }
}
