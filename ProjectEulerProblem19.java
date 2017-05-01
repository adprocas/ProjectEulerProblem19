package projecteulerproblem19;

import java.util.*;

/**
 *
 * @author Adam Leathorn
 */
public class ProjectEulerProblem19 {

    /**
     * @param args the command line arguments
     */
    int weekDay = 0;
    int monthDay = 1;
    int month = 1;
    int year = 1900;

    int firstOfMonthCount = 0;

    public static void main(String[] args) {
        ProjectEulerProblem19 solution = new ProjectEulerProblem19();
        solution.run();
    }

    private List<List<Integer>> numbers;

    public ProjectEulerProblem19() {

    }

    public void run() {
        while (!(year == 2000 && monthDay == 31 && month == 12)) {
            if ((year >= 1901) && (weekDay == 6 && monthDay == 1)) {
                firstOfMonthCount++;
                System.out.println("Found Sunday on First Day of Month: ");
                printDate();
            }

            nextDay();
        }

        System.out.println(firstOfMonthCount);
    }

    /*
    logic...
    Check the current day - if it's the start of the month
    and a sunday, add to counter, but only if it's Jan 1, 1901 or after
    and on or before Dec 31, 2000

    Get the next day
    check if end of the month
        if Feb 28, check for leap year
     */
    public void nextDay() {
        if (monthDay == 28 && month == 2 && isLeapYear()) {
            monthDay++;
        } else {
            moveForwardOneDay();
        }

        moveWeekDay();
    }

    private void moveForwardOneDay() {
        if (((month == 9 || month == 4 || month == 6 || month == 11) && monthDay == 30)
                || ((month == 2) && (monthDay == 28 || monthDay == 29))) {
            month++;
            monthDay = 1;
        } else if (monthDay == 31) {
            if (month == 12) {
                year++;
                month = 1;
                monthDay = 1;
            } else {
                month++;
                monthDay = 1;
            }
        } else {
            monthDay++;
        }
    }

    private void moveWeekDay() {
        if (weekDay == 6) {
            weekDay = 0;
        } else {
            weekDay++;
        }
    }

    private boolean isLeapYear() {
        boolean leap = (year % 4 == 0) && ((year % 100 != 0) || (year % 100 == 0 && year % 400 == 0));

        if (leap) {
            System.out.println("Found Leap Year: ");
            printDate();
        }

        return leap;
    }

    private void printDate() {
        System.out.println("Year: " + year + " -- Month: " + month + " -- Day: " + monthDay + " -- WeekDay: " + weekDay + " -- Number of Sundays on first of Month: " + firstOfMonthCount);
        System.out.println();
    }
}
