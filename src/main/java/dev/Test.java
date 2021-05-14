package dev;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int[] arr = new int[]{100, 120, 130, 150, 280, 765, 345};
        int index = 0;
        reverse(arr, index);
//        arr.forEach(e -> System.out.println(e.getClass()));
        Arrays.stream(arr).forEach(System.out::println);


//        for (int i = 0; i < arr.length / 2; i++) {
//            // swapping over the two respective values in the reverse order
//            int temp = arr[i];
//            arr[i] = arr[arr.length - 1 - i];
//            arr[arr.length - 1 - i] = temp;
//        }
//        list.forEach((e) -> System.out.println(((Integer) e).toString()));
//        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int index) {

        if (index < arr.length / 2) {
            int temp = arr[index];
            arr[index] = arr[arr.length - 1 - index];
            arr[arr.length - 1 - index] = temp;
            index += 1;
            reverse(arr, index);
        }

    }

}
