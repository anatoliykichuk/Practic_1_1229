package com.company.lesson4;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.HashMap;
import java.util.Map;
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
        initializePlayingMAp();
        displayPlayingMap();

        boolean isWin = isWin(EMPTY_TAG);

        while (isWin) {
            if (makeUserMove()) break;
            if (makePCMove()) break;
        }
        scanner.close();
    }

    public static boolean makeUserMove() {
        int row, column;
        boolean isAdressIncorect;

        System.out.println("Ваш ход");

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
                playing_map[row - 1][column - 1] = USER_TAG;
            }

        } while (isAdressIncorect);

        displayPlayingMap();

        return isWin(USER_TAG);
    }

    public static boolean makePCMove() {
        int row, column;
        boolean isAdressIncorect;

        System.out.println("Ход ПК");

        Random random = new Random();

        do {
            row = random.nextInt(playing_map.length);
            column = random.nextInt(playing_map.length);

            isAdressIncorect = isAdressIncorect(row, column);

            if (!isAdressIncorect) {
                playing_map[row - 1][column - 1] = PC_TAG;
            }

        } while (isAdressIncorect);

        displayPlayingMap();

        return isWin(PC_TAG);
    }

    public static boolean isAdressIncorect(int row, int column) {
        return row < 1 || row > playing_map.length ||
                column < 1 || column > playing_map.length ||
                playing_map[row - 1][column - 1] != EMPTY_TAG;
    }

    public static boolean isWin(char tag) {
        if (tag == EMPTY_TAG) {
            return false;
        }

        return true;
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
