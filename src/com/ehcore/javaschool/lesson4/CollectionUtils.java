package com.ehcore.javaschool.lesson4;

import java.util.*;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination){
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList(){
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<T> source, T t){
        return source.indexOf(t);
    }

    //**
    public static <T> List<? super T> limit(List<? extends T> source, int size){
        return null;
    }

    public static <T> void add(List<T> source, T t){
        source.add(t);
    }

    public static <T> void removeAll(List<T> removeFrom, List<T> c2){
        removeFrom.removeAll(c2);
    }

    //**
    public static <T> boolean containsAll(List<T> c1, List<T> c2){
        return false;
    }

    //**
    public static <T> boolean containsAny(List<T> c1, List<T> c2){
        return false;
    }

    //**
    public static <T> List<T> range(List<T> list, T min, T max){
        return null;
    }

    //**
    public static <T> List<T> range(List<T> list, T max, Comparator<T> comparator){
        return null;
    }
}
