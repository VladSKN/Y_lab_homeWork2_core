package homeWork_task3;

/*
Task3
    Реализовать функцию нечеткого поиска

            fuzzySearch("car", "ca6$$#_rtwheel"); // true
            fuzzySearch("cwhl", "cartwheel"); // true
            fuzzySearch("cwhee", "cartwheel"); // true
            fuzzySearch("cartwheel", "cartwheel"); // true
            fuzzySearch("cwheeel", "cartwheel"); // false -  разобрать этот кейс
            fuzzySearch("lw", "cartwheel"); // false
 */

public class FuzzySearch {
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
    }

    public static boolean fuzzySearch(String substr, String str) {
        int pointer1 = 0;
        int pointer2 = 0;

        if(substr == null || str == null){
            throw new IllegalArgumentException();
        }

        while (pointer2 != str.length() && pointer1 != substr.length()) {
            if (substr.charAt(pointer1) == str.charAt(pointer2)) {
                pointer1++;
            }
            pointer2++;
        }
        return pointer1 == substr.length();
    }
}
