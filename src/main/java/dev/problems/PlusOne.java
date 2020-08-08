package dev.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/plus-one/
public class PlusOne {

    public static <T> void main(String[] args) {

//        int[] nums = new int[]{9, 9, 9, 9};
//        int[] nums = new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
//        int[] nums = new int[]{1, 2, 3};
        int[] nums = new int[]{4, 3, 2, 1};
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(nums)));
    }

    public int[] plusOne(int[] digits) {

        int length = digits.length;
        int lastIndex = length - 1;

        int carry = 0;

        // creating the result array after adding 1
        for (int indexOfDigits = lastIndex; indexOfDigits > -1; indexOfDigits--) {
            // If it is 9 in the last index, we just add 0 and store the carry 1
            if (indexOfDigits == lastIndex && digits[indexOfDigits] == 9) {
                digits[indexOfDigits] = 0;
                carry = 1;
            }
            // if it is a 9 when there is a carry, we just make it 0 and store the carry again
            else if (carry == 1 && digits[indexOfDigits] == 9) {
                digits[indexOfDigits] = 0;
                carry = 1;
            }
            // If it is not related to 9, we just store it by adding carry or by adding 1 to the last index
            else {
                if (indexOfDigits == lastIndex) {
                    digits[indexOfDigits] = digits[indexOfDigits] + 1;
                } else {
                    digits[indexOfDigits] = carry == 1 ? digits[indexOfDigits] + carry : digits[indexOfDigits];
                }
                carry = 0;
            }
        }


        // If there is a carry still, we would need to add 1 at the start of the array.
        // It is 1 because we are just adding one to the given number so there won't be carry larger than 1.
        if (carry == 1) {
            int[] finalResult = new int[length + 1];
            finalResult[0] = 1;
            System.arraycopy(digits, 0, finalResult, 1, length);
            digits = finalResult;
        }
        return digits;
    }

}
