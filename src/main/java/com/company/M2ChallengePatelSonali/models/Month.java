package com.company.M2ChallengePatelSonali.models;

import java.util.Objects;

public class Month {

    private int monthNumber;
    private String month;

//    Constructor, Getter, Setter, HashMap, toString
    public Month(int monthNumber, String month) {
        this.monthNumber = monthNumber;
        this.month = month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month1 = (Month) o;
        return monthNumber == month1.monthNumber && Objects.equals(month, month1.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthNumber, month);
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthNumber=" + monthNumber +
                ", month='" + month + '\'' +
                '}';
    }
}
