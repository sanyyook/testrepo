package com.kordunyan.entity;

import java.time.LocalDate;

public class DateMark {
    private LocalDate date;
    private int mark;

    public DateMark(LocalDate date, int mark) {
        this.date = date;
        this.mark = mark;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
