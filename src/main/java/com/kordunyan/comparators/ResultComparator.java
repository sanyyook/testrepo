package com.kordunyan.comparators;

import com.kordunyan.entity.Results;

import java.util.Comparator;

public class ResultComparator implements Comparator<Results> {
    public int compare(Results res1, Results res2){
        return res1.getSubject().getTitle().compareTo(res2.getSubject().getTitle());
    }
}
