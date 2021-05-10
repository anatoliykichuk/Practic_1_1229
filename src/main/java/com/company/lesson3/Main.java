package com.company.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main() {
        System.out.println("\nДомашнее задание по уроку 3:");

        playGuessingNumberGame();
        playGuessingWordsGame();

        scanner.close();
    }

    public static void playGuessingNumberGame() {
        int minNumber = 0;
        int maxNumber = 9;
        int tryCount = 3;
        int positiveAnswer = 1;
        int negativeAnswer = 0;

        System.out.println("Сыграем в угадайку?\nПопытайтесь угадать число от " + minNumber
                + " до " + maxNumber + " за " + tryCount + " попытки...");

        do {
            runGuessingNumberGame(minNumber, maxNumber, tryCount);
            System.out.print("Повторить игру еще раз? " + positiveAnswer + " – да / " + negativeAnswer + " – нет\n");

        } while (scanner.nextInt() == positiveAnswer);
    }

    public static void runGuessingNumberGame(int minNumber, int maxNumber, int tryCount) {

        int number = (int) (Math.random() * (maxNumber - minNumber + 1) + minNumber);

        for (int tryNumber = 1; tryNumber <= tryCount; tryNumber++) {
            System.out.print(tryNumber + "-я попытка: ");
            int answer = scanner.nextInt();

            if (answer == number) {
                System.out.println("Поздравляем! Вы угадали!");
                break;
            } else {
                System.out.println("К сожалению, не угадали - введенное число "
                        + answerRepresentation(number, answer) + " загаданного.\nОсталось еще "
                        + (tryCount - tryNumber) + " попытки");

                if (tryNumber == tryCount) {
                    System.out.println("Загаданное чило - " + number);
                }
            }
        }
    }

    public static String answerRepresentation(int number, int answer) {
        if (answer > number) {
            return "больше";
        }
        return "меньше";
    }

    public static void playGuessingWordsGame() {
        String word = randomWord();
        String prompt = wordPrompt(word);
        boolean isIncorrectAnswer;

        System.out.println("Угадайте слово: " + prompt);

        do {
            String answer = scanner.nextLine();
            isIncorrectAnswer = !answer.toLowerCase().equals(word);

            if (isIncorrectAnswer) {
                System.out.println("К сожалению, Вы не угадали. Повторите попытку");
            } else {
                System.out.println("Поздравляем! Вы угадали.\nИгра закончена.");
            }
        } while (isIncorrectAnswer);
    }

    public static String wordPrompt(String word) {
        StringBuilder builder = new StringBuilder();

        builder.append(word.charAt(0));
        builder.append(word.charAt(1));
        builder.append("#############");

        return builder.toString();
    }

    public static String randomWord() {
        String[] words = words();
        int wordIndex = new Random().nextInt(words.length);

        return words[wordIndex];
    }

    public static String[] words() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        return words;
    }
}
