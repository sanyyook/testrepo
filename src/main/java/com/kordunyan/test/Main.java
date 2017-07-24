package com.kordunyan.test;

import com.kordunyan.entity.DateMark;
import com.kordunyan.entity.Results;
import com.kordunyan.entity.Subject;
import com.kordunyan.comparators.DateComparator;
import com.kordunyan.comparators.ResultComparator;
import com.kordunyan.services.ExamResultService;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {

    private Map<LocalDate, Set<Results>> map = new HashMap<>();


    public static void main(String[] args) {

        ExamResultService examResult = new ExamResultService();

        /*try{
            examResult.addResult(LocalDate.of(2017, Month.APRIL, 2), new Results(new Subject("Math"), 15));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }*/


        System.out.println("Get avarage score\n");
        System.out.println(examResult.getAvgBySubject(new Subject("Math")));


        System.out.println("\nSeach by data\n");
        Set<Results> resultByData = examResult.searchByData(LocalDate.of(2017, Month.APRIL, 2));
        for(Results result : resultByData){
            System.out.println(String.format("%s : %d", result.getSubject().getTitle(), result.getMark()));
        }
        System.out.println("\nGet by subject \n");

        Set<DateMark>  dateMarks = examResult.getBySubject(new Subject("Math"));
        for(DateMark dateMark : dateMarks){
            System.out.println(dateMark.getDate() + " : " + dateMark.getMark());
        }
    }

}
