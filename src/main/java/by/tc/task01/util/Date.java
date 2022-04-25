package by.tc.task01.util;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(String dateString) {
        int dayIndex = dateString.indexOf("/");
        day = Integer.parseInt(dateString.substring(0, dayIndex));
        int monthIndex = dateString.lastIndexOf("/");
        month = Integer.parseInt(dateString.substring(dayIndex+1, monthIndex));
        int yearIndex = dateString.length();
        year = Integer.parseInt(dateString.substring(monthIndex+1, yearIndex));
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
