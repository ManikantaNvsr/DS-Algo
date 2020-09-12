package dev.problems.leetcode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

public class LastFridayOfEveryMonth {

    public static void main(String[] args) {

        int year = 2020;

        printLastFridayOfEveryMonth(year);

    }

    public static void printLastFridayOfEveryMonth(int year) {

        for (int i = 1; i <= 12; i++) {

            LocalDate localDate = LocalDate.of(year, i, 1);

            LocalDate lastFridayInMonth = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));

//            LocalDate lastDayOfTheMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
//            LocalDate nextFriday = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
//            LocalDate firstSunday = localDate.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));

            System.out.println("lastFridayInMonth " + lastFridayInMonth);

//            System.out.println( "next Friday " + nextFriday);
//            System.out.println("lastDayOfTheMonth: " + lastDayOfTheMonth);

//            System.out.println(firstSunday);

        }


    }
}
