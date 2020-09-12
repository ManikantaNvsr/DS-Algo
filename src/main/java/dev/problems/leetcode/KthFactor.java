package dev.problems.leetcode;

// https://leetcode.com/contest/biweekly-contest-29/problems/the-kth-factor-of-n/
public class KthFactor {

    public static void main(String[] args) {
        KthFactor kthFactor = new KthFactor();
        System.out.println(kthFactor.kthFactor(4, 4));
        System.out.println(kthFactor.kthFactor(12, 3));
        System.out.println(kthFactor.kthFactor(7, 2));
        System.out.println(kthFactor.kthFactor(1, 1));
        System.out.println(kthFactor.kthFactor(1000, 3));
    }


    public int kthFactor(int n, int k) {
        int factor = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && k > 0) {
                k--;
                if (k == 0) {
                    factor = i;
                }
            }
        }

        if (factor != 0) {
            return factor;
        }

        return -1;

    }
}
