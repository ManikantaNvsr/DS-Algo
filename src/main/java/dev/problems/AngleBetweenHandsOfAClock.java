package dev.problems;

// https://leetcode.com/problems/angle-between-hands-of-a-clock/
public class AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
        AngleBetweenHandsOfAClock angleBetweenHandsOfAClock = new AngleBetweenHandsOfAClock();
        System.out.println(angleBetweenHandsOfAClock.angleClock(3, 30));
        System.out.println(angleBetweenHandsOfAClock.angleClock(12, 30));
        System.out.println(angleBetweenHandsOfAClock.angleClock(3, 15));
        System.out.println(angleBetweenHandsOfAClock.angleClock(4, 50));
        System.out.println(angleBetweenHandsOfAClock.angleClock(12, 0));
        System.out.println(angleBetweenHandsOfAClock.angleClock(1, 57));
    }

    public double angleClock(int hour, int minutes) {

        double minutesConverted = minutes;

        int angleCoveredByMinuteHand = minutes * 6;

        if (hour == 12) {
            hour = 0;
        }

        double angleCoveredByHourHand = (hour * 30) + ((minutesConverted / 60) * 30);

        double angle = Math.abs(angleCoveredByHourHand - angleCoveredByMinuteHand);

        return angle > 180 ? 360 - angle : angle;
    }
}
