package Arr.sort.quiq;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        var random = new Random();
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(5);
        }
        System.out.println("Before: ");
        printArrays(numbers);

        quicksort(numbers);

        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("\nAfter: ");
        printArrays(numbers);
     }
    static void quicksort(int[] array){
        quicksort(array, 0, array.length - 1);
    }
    private static void quicksort(int[] array, int lowIndex, int highIndex){
        if (lowIndex >= highIndex){
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;

        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer){
        
            while (array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }while (array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArrays(int[] numbers){
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
    }

}

