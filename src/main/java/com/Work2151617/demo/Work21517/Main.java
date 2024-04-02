package com.Work2151617.demo.Work21517;

public class Main {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        int[] arr = {
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,
                5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38, 5, 89, 45, 37, 15, 27, 78, 64, 2, 9, 38,};

        int[] arrBubble = arr.clone();
        startTime = System.currentTimeMillis();
        sortBubble(arrBubble);
        endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " milliseconds");

        int[] arrSelection = arr.clone();
        startTime = System.currentTimeMillis();
        sortSelection(arrSelection);
        endTime = System.currentTimeMillis();
        System.out.println("Selection Sort Time: " + (endTime - startTime) + " milliseconds");

        int[] arrInsertion = arr.clone();
        startTime = System.currentTimeMillis();
        sortInsertion(arrInsertion);
        endTime = System.currentTimeMillis();
        System.out.println("Insertion Sort Time: " + (endTime - startTime) + " milliseconds");


    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
