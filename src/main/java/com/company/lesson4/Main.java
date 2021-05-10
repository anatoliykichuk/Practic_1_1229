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
        initializePlayingMAp();
        displayPlayingMap();

        boolean isNotWin = !isWin(EMPTY_TAG);

        while (isNotWin) {
            makeUserMove();

            if (isWin(USER_TAG)) {
                System.out.println("Поздравляем! Вы победили!");
                break;
            }

            if (isNobodyWon()) {
                System.out.println("Ничья!");
                break;
            }

            makePCMove();

            if (isWin(PC_TAG)) {
                System.out.println("Победил ПК...");
                break;
            }

            if (isNobodyWon()) {
                System.out.println("Ничья!");
                break;
            }
        }
        scanner.close();
    }

    public static void makeUserMove() {
        int row, column;
        boolean isAdressIncorect;

        System.out.println("Ваш ход...");

        do {
            System.out.println("Укажите адрес ячейки:");
            System.out.print("- номер строки: ");
            row = scanner.nextInt() - 1;

            System.out.print("- номер колонки: ");
            column = scanner.nextInt() - 1;

            isAdressIncorect = isAdressIncorect(row, column);

            if (isAdressIncorect) {
                System.out.println("\nАдрес некорректен - повторите попытку...");
            } else {
                playing_map[row][column] = USER_TAG;
            }

        } while (isAdressIncorect);

        displayPlayingMap();
    }

    public static void makePCMove() {
        int row, column;
        boolean isAdressIncorect;

        System.out.println("Ход ПК...");

        Random random = new Random();

        do {
            row = random.nextInt(playing_map.length);
            column = random.nextInt(playing_map.length);

            isAdressIncorect = isAdressIncorect(row, column);

            if (!isAdressIncorect) {
                playing_map[row][column] = PC_TAG;
            }

        } while (isAdressIncorect);

        displayPlayingMap();
    }

    public static boolean isAdressIncorect(int row, int column) {
        return row < 0 || row >= playing_map.length ||
                column < 0 || column >= playing_map.length ||
                playing_map[row][column] != EMPTY_TAG;
    }

    public static boolean isWin(char tag) {
        if (tag == EMPTY_TAG) {
            return false;
        }

        return filledOnDirectlyDiagonal(tag) ||
                filledOnReverselyDiagonal(tag) ||
                filledOnHorizontally(tag) ||
                filledOnVertically(tag);
    }

    public static boolean filledOnDirectlyDiagonal(char tag) {
        int tagsCountOnDirectlyDiagonal = 0;

        for (int index = 0; index < playing_map.length; index++) {

            if (playing_map[index][index] == tag) {
                tagsCountOnDirectlyDiagonal++;

                if (tagsCountOnDirectlyDiagonal == playing_map.length) return true;

                if (tagsCountOnDirectlyDiagonal == POINTS_TO_WIN &&
                        (playing_map[0][0] != tag ||
                                playing_map[playing_map.length - 1][playing_map.length - 1] != tag)) return true;
            }
        }
        return false;
    }

    public static boolean filledOnReverselyDiagonal(char tag) {
        int tagsCountOnReverselyDiagonal = 0;

        for (int index = 0; index < playing_map.length; index++) {

            if (playing_map[index][playing_map.length - index - 1] == tag) {
                tagsCountOnReverselyDiagonal++;

                if (tagsCountOnReverselyDiagonal == playing_map.length) return true;

                if (tagsCountOnReverselyDiagonal == POINTS_TO_WIN &&
                        (playing_map[0][playing_map.length - 1] != tag ||
                                playing_map[playing_map.length - 1][0] != tag)) return true;
            }
        }
        return false;
    }

    public static boolean filledOnHorizontally(char tag) {

        for (int externalIndex = 0; externalIndex < playing_map.length; externalIndex++) {
            int tagsCountOnRow = 0;

            for (int internalIndex = 0; internalIndex < playing_map.length; internalIndex++) {

                if (playing_map[externalIndex][internalIndex] == tag) {
                    tagsCountOnRow++;

                    if (tagsCountOnRow == playing_map.length) return true;

                    if (tagsCountOnRow == POINTS_TO_WIN &&
                            (playing_map[externalIndex][0] != tag ||
                                    playing_map[externalIndex][playing_map.length - 1] != tag)) return true;
                }
            }
        }
        return false;
    }

    public static boolean filledOnVertically(char tag) {

        for (int externalIndex = 0; externalIndex < playing_map.length; externalIndex++) {
            int tagsCountOnColumn = 0;

            for (int internalIndex = 0; internalIndex < playing_map.length; internalIndex++) {

                if (playing_map[internalIndex][externalIndex] == tag) {
                    tagsCountOnColumn++;

                    if (tagsCountOnColumn == playing_map.length) return true;

                    if (tagsCountOnColumn == POINTS_TO_WIN &&
                            (playing_map[0][externalIndex] != tag ||
                                    playing_map[playing_map.length - 1][externalIndex] != tag)) return true;
                }
            }
        }
        return false;
    }

    public static boolean isNobodyWon() {

        for (int externalIndex = 0; externalIndex < playing_map.length; externalIndex++) {

            for (int internalIndex = 0; internalIndex < playing_map.length; internalIndex++) {

                if (playing_map[externalIndex][internalIndex] == EMPTY_TAG) {
                    return false;
                }
            }
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
