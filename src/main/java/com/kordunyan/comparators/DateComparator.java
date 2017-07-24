package com.kordunyan.comparators;

import com.kordunyan.entity.DateMark;

import java.util.Comparator;

public class DateComparator implements Comparator<DateMark> {
    public int compare(DateMark date1, DateMark date2){
        return date1.getDate().compareTo(date2.getDate());
    }
}
