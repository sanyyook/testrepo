package com.kordunyan.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kordunyan.comparators.ResultComparator;
import com.kordunyan.entity.Results;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kordunyan.entity.Subject;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExamResultDAO {

    private ObjectMapper mapper = new ObjectMapper();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String FILE_PATH = "examresults.json";

    public ExamResultDAO(){

    }

    public void save(Map<LocalDate, Set<Results>> map){
        try(Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(map, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<LocalDate, Set<Results>> loadData(){
        Map<LocalDate, Set<Results>> result = new HashMap<>();
        try{
            Type type = new TypeToken<Map<String, Set<Results>>>(){}.getType();
            BufferedReader br = new BufferedReader( new FileReader(FILE_PATH));
            Map<String, Set<Results>> loadMap = gson.fromJson(br, type);

            for(Map.Entry<String, Set<Results>> entry : loadMap.entrySet()){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(entry.getKey(), dtf);
                result.put(LocalDate.parse(entry.getKey(), dtf), entry.getValue());
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

}
