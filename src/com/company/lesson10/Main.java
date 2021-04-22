package com.company.lesson10;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main() {
        getWordsStatistics();
    }

    public static void getWordsStatistics() {
        ArrayList<String> words = getWords();
        System.out.printf("1. Всего слов: %d\n%s\n", words.size(), words.toString());

        Set<String> uniqueWords = new HashSet<>(words);
        System.out.printf("2. Уникальных слов: %d\n%s\n", uniqueWords.size(), uniqueWords.toString());

        Map<String, Integer> wordsCounter = new HashMap<>();

        for (String uniqueWord: uniqueWords) {
            int count = 0;
            for (String word: words) {
                if (word.equals(uniqueWord)) count++;
            }
            wordsCounter.put(uniqueWord, count);
        }
        System.out.printf("3. Частота слов:\n%s\n", wordsCounter.toString());
    }

    public static ArrayList<String> getWords() {
        ArrayList<String> words = new ArrayList<>();
        words.add("child");
        words.add("woman");
        words.add("parents");
        words.add("father");
        words.add("dad");
        words.add("engineer");
        words.add("mother");
        words.add("child");
        words.add("worker");
        words.add("boy");
        words.add("businessman");
        words.add("teacher");
        words.add("dad");
        words.add("driver");
        words.add("worker");
        words.add("engineer");
        words.add("dad");
        words.add("girl");
        words.add("doctor");
        words.add("mum");

        return words;
    }

}
