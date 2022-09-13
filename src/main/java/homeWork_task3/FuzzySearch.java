package homeWork_task3;

/*
Task3
    Реализовать функцию нечеткого поиска

            fuzzySearch("car", "ca6$$#_rtwheel"); // true
            fuzzySearch("cwhl", "cartwheel"); // true
            fuzzySearch("cwhee", "cartwheel"); // true
            fuzzySearch("cartwheel", "cartwheel"); // true
            fuzzySearch("cwheeel", "cartwheel"); // false
            fuzzySearch("lw", "cartwheel"); // false
 */

import java.util.Objects;

public class FuzzySearch {
    public static void main(String[] args) {
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    /**
     * Для решения данной задачи был выбран жадный алгоритм
     * с двумя независимыми указателями, временная сложность
     * данного алгоритма O( n )
     *
     * @return boolean true or false
     */
    public static boolean fuzzySearch(String substr, String str) {

        if (substr == null || str == null) {
            throw new IllegalArgumentException();
        }

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer2 != str.length() && pointer1 != substr.length()) {
            if (Objects.equals(substr.charAt(pointer1), str.charAt(pointer2))) {
                pointer1++;
            }
            pointer2++;
        }
        return pointer1 == substr.length();
    }
}
