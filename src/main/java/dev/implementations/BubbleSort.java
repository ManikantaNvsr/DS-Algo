package dev.implementations;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // Bubble sort

        int[] arr = new int[]{2, 5, 6 , 1, 10};

        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr.length - 1; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


}
