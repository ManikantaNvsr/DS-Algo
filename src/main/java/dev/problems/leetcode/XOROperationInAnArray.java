package dev.problems.leetcode;
// https://leetcode.com/contest/weekly-contest-194/problems/xor-operation-in-an-array/
public class XOROperationInAnArray {

    public static void main(String[] args) {
        XOROperationInAnArray obj = new XOROperationInAnArray();
        System.out.println(obj.xorOperation(5, 0));
    }

    public int xorOperation(int n, int start) {

        int[] nums = new int[n];

        int result=0;

        for(int i=0; i < nums.length; i++){
            nums[i] = start + 2 * i;

            if(i == 0){
                result = nums[i];
            }
            else
            {
                result ^= nums[i];
            }

        }

        return result;

    }
}
