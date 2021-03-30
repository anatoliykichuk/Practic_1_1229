package com.company.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] playing_map;
    public static final int PLYING_MAP_SIZE = 5;
    public static final int POINTS_TO_WIN = 4;

    public static final char EMPTY_TAG = '*';
    public static final char USER_TAG = 'X';
    public static final char PC_TAG = 'O';

    public static Scanner scanner = new Scanner(System.in);

    public static void main() {

        /*
        * заполнить игровое поле
        * реализовать вывода поля
        * реализовать метод выполнения ходов
        * реализовать метод проверки результата - выйграл ли игрок
        */

        initializePlayingMAp();
        displayPlayingMap();

        //for (int move = 0; move < POINTS_TO_WIN; move++) {

            makeMove(true);
            displayPlayingMap();

        //}

        scanner.close();
    }

    public static void makeMove(boolean isUser) {
        int row, column;
        boolean isAdressIncorect;

        do {
            System.out.println("Укажите адрес ячейки:");
            System.out.print("- номер строки: ");
            row = scanner.nextInt();

            System.out.print("- номер колонки: ");
            column = scanner.nextInt();

            isAdressIncorect = isAdressIncorect(row, column);

            if (isAdressIncorect) {
                System.out.println("Адрес некорректен - повторите попытку.");
            } else {
                playing_map[row - 1][column - 1] = isUser ? USER_TAG :PC_TAG;
            }

        } while (isAdressIncorect);
    }

    public static boolean isAdressIncorect(int row, int column) {
        return row < 1 || row > playing_map.length ||
                column < 1 || column > playing_map.length ||
                playing_map[row - 1][column - 1] != EMPTY_TAG;
    }

    public static void initializePlayingMAp() {
        playing_map = new char[PLYING_MAP_SIZE][PLYING_MAP_SIZE];

        for (int row = 0; row < playing_map.length; row++) {
            for (int column = 0; column < playing_map.length; column++) {
                playing_map[row][column] = EMPTY_TAG;
            }
        }
    }

    public static void displayPlayingMap() {
        StringBuilder playingMapRepresentaition = new StringBuilder();

        for (int index = 0; index <= playing_map.length; index++) {
            playingMapRepresentaition.append(index).append("\t");
        }

        playingMapRepresentaition.append(System.lineSeparator());

        for (int row = 0; row < playing_map.length; row++) {
            playingMapRepresentaition.append(row + 1).append("\t");

            for (int column = 0; column < playing_map.length; column++) {
                playingMapRepresentaition.append(playing_map[row][column]).append("\t");
            }
            playingMapRepresentaition.append(System.lineSeparator());
        }
        System.out.println(playingMapRepresentaition.toString());
    }
}
