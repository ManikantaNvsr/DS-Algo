package dev.problems;

//https://leetcode.com/problems/powx-n/
public class Pow {

    public static void main(String[] args) {
        Pow pow = new Pow();
//        System.out.println(pow.myPow(0.00001, 2147483647));
    }

//    public double myPow(double x, int n) {
//        // naive approach
//        /*double result = 1;
//        boolean isItNegative = false;
//        if (n < 0) {
//            n = n * -1;
//            isItNegative = true;
//        } else if (n == 0) {
//            return 1;
//        }
//        for (int i = 1; i <= n; i++) {
//            x *= x;
//        }
//        return isItNegative ? 1 / result : result;*/
//
//        // efficient
//                    if(n == 0)
//                return 1;
//            if(x == 0.0)
//                return x;
//            if(n == 1)
//                return x;
//
//            double ans = power(x, n/2);
//            if(n%2 == 0)
//                return ans*ans;
//            else
//                return x*ans*ans;
//        }

//    public double myPow(double x, int n) {
//        return n > 0 ? power(x,n) : 1/power(x,n);
//    }


}
