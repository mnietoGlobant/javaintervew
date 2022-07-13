package com.globant.javainterview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaTests {

    public static void main(String[] args) {
        System.out.println("Is palindrome = " + isPalindrome("Anita lava la tina"));
        System.out.println("Is anagram = " + isAnagram("abc", "bca"));
        System.out.println("Permutations:");
        permutations("ABCD");

        List<String> data = List.of("A", "B", "C");
        System.out.println(data.stream().map(String::toLowerCase).collect(Collectors.toList()));
    }

    public static boolean isPalindrome(String phrase) {
        phrase = phrase.replaceAll(" ", "");
        StringBuilder sb = new StringBuilder(phrase);
        String rev = sb.reverse().toString();

        return phrase.equalsIgnoreCase(rev);
    }

    public static boolean isAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        return Arrays.equals(charFromWord, charFromAnagram);
    }


    public static void permutations(String input) {
        permutation("", input);
    }

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }
}
