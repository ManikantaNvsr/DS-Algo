package dev.problems;

// Leet Code: 713
// https://leetcode.com/problems/subarray-product-less-than-k/
public class SubArrayProductLessThanK {

    public long numSubarrayProductLessThanK(int[] nums, int k) {

        int length = nums.length;
        // Sliding Window Approach
        // There can't be any subset if it is zero or 1.
        if (k <= 1) {
            return 0;
        }

        int numberOfSubArrays = 0;
        int product = 1;


        // grows as we add elements to the product
        // tells us the last windowRightIndex of the window at any point
        int windowRightIndex = 0;
        // To keep track of start of the window at any point
        int windowLeftIndex = 0;


        while
        (windowRightIndex < length){
            product = product * nums[windowRightIndex];
            while(product >= k) product /= nums[windowLeftIndex++];
            numberOfSubArrays += windowRightIndex - windowLeftIndex +1;
            windowRightIndex++;
        }

        return numberOfSubArrays;

        // Simple Refactoring done above so commenting the below code.
/*        while (windowLeftIndex < length) {

            // If windowRightIndex is greater than array length means we reached to a point with windowLeftIndex, from that place to the end of the array elements whose product is less than the given k.
            if (windowRightIndex < length) {
                product = product * nums[windowRightIndex];
            } // Since all the right elements can be part of the product, we just to increase index of the window start to find the number of subArrays
            else {
                System.out.println(windowLeftIndex + "---" + windowRightIndex);
                System.out.println("first else");
                numberOfSubArrays = numberOfSubArrays + windowRightIndex - windowLeftIndex;

                System.out.println("first else: numberOfSubArrays from this window --" + (windowRightIndex - windowLeftIndex));
                System.out.println("first else: numberOfSubArrays--" + numberOfSubArrays);

                product = product / nums[windowLeftIndex];
                windowLeftIndex++;

                continue;

            }


            // If the product less than k, we are increasing the window size at the right side.
            if (product < k) {
                windowRightIndex++;

            }// window has reached a maximum extent where all the window elements product is more than k so we drop the element at the start of the window
            else {
                System.out.println(windowLeftIndex + "---" + windowRightIndex);
                System.out.println("else");
                numberOfSubArrays = numberOfSubArrays + windowRightIndex - windowLeftIndex;

                System.out.println("else: numberOfSubArrays from this window --" + (windowRightIndex - windowLeftIndex));
                System.out.println("else: numberOfSubArrays--" + numberOfSubArrays);

                product = product / nums[windowLeftIndex];
                product = product / nums[windowRightIndex];
                windowLeftIndex++;

                product = 1;
                windowRightIndex = ++windowLeftIndex;
            }
        }

        return numberOfSubArrays;*/


    }

    public static void main(String[] args) {
        SubArrayProductLessThanK subArrayProductLessThanK = new SubArrayProductLessThanK();

        // [10,9,10,4,3,8,3,3,6,2,10,10,9,3]
        //19
        // 18


        // int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
         int[] nums = {10, 5, 2, 6};
        System.out.println(subArrayProductLessThanK.numSubarrayProductLessThanK(nums, 100));
    }
}
