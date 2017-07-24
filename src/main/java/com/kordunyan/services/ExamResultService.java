package com.kordunyan.services;

import com.kordunyan.DAO.ExamResultDAO;
import com.kordunyan.comparators.DateComparator;
import com.kordunyan.comparators.ResultComparator;
import com.kordunyan.entity.DateMark;
import com.kordunyan.entity.Results;
import com.kordunyan.entity.Subject;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ExamResultService {
    private Map<LocalDate, Set<Results>> map = new HashMap<>();

    public ExamResultService(){
        Subject subjEnglish = new Subject("English");
        Subject subjCpp = new Subject("C++");
        Subject subjJava = new Subject("Java");
        Subject subjMath = new Subject("Math");
        Subject subjPhisic = new Subject("Phisic");
        Subject subjAlgebra = new Subject("Boook");


        map = new HashMap<>();

        ResultComparator comparator = new ResultComparator();

        Set<Results> results = new TreeSet<>(comparator);
        results.add(new Results(subjEnglish, 12));
        results.add(new Results(subjCpp, 13));
        results.add(new Results(subjMath, 10));

        map.put(LocalDate.of(2017, Month.APRIL, 1), results);


        results = new TreeSet<>(comparator);
        results.add(new Results(subjJava, 10));
        results.add(new Results(subjPhisic, 8));
        results.add(new Results(subjMath, 15));
        results.add(new Results(subjAlgebra, 20));

        map.put(LocalDate.of(2017, Month.APRIL, 2), results);

        results = new TreeSet<>(comparator);
        results.add(new Results(subjCpp, 10));
        results.add(new Results(subjPhisic, 13));
        results.add(new Results(subjMath, 18));

        map.put(LocalDate.of(2017, Month.APRIL, 3), results);

        ExamResultDAO dao = new ExamResultDAO();
        //dao.save(map);
        //map = dao.loadData();

    }

    public void addResult(LocalDate date, Results result) throws Exception {
        if(map.containsKey(date)){
            Set<Results> res = map.get(date);
            if(res.contains(result)){
                throw new Exception("Such subject exists in this date");
            }
            else{
                res.add(result);
            }
        }
        else{
            Set<Results> res = new TreeSet<>(new ResultComparator());
            res.add(result);
            map.put(date, res);
        }
    }

    public double getAvgBySubject(Subject subject){
        double result = 0.0;
        int count = 0;
        for(Map.Entry<LocalDate, Set<Results>> entry : map.entrySet()){
            for(Results res : entry.getValue()){
                if(res.getSubject().equals(subject)){
                    result += res.getMark();
                    count++;
                }
            }
        }
        return (count > 0)? result/count : 0;
    }

    public Set<Results>  searchByData(LocalDate date){
        return map.get(date);
    }

    public Set<DateMark>  getBySubject(Subject subject){
        Set<DateMark> result = new TreeSet<>(new DateComparator());
        for(Map.Entry<LocalDate, Set<Results>> entry : map.entrySet()){
            for(Results res : entry.getValue()){
                if(res.getSubject().equals(subject)){
                    result.add(new DateMark(entry.getKey(), res.getMark()));
                }
            }
        }
        return result;
    }

}
