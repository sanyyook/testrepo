package com.kordunyan.entity;

public class Results{
    private Subject subject;
    private Integer mark;

    public Subject getSubject() {
        return subject;
    }

    public Results(Subject subject, Integer mark) {
        this.subject = subject;
        this.mark = mark;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Results results = (Results) o;

        return subject != null ? subject.equals(results.subject) : results.subject == null;
    }

    @Override
    public int hashCode() {
        return subject != null ? subject.hashCode() : 0;
    }
}
