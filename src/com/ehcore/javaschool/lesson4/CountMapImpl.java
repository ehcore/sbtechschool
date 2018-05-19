package com.ehcore.javaschool.lesson4;


import java.util.*;

public class CountMapImpl<T> implements CountMap<T>{
    private Map<T,Integer> map = new TreeMap<T, Integer>();

    @Override
    public void add(T t) {
        if(!map.containsKey(t)){
            map.put(t,1);
        }else{
            map.put(t,map.get(t) + 1);
        }
    }

    @Override
    public int getCount(T t) {
        return map.get(t);
    }

    @Override
    public int remove(T t) {
        return map.remove(t);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        Map<T,Integer> tempMap = source.toMap();
        for(Map.Entry<T,Integer> e : tempMap.entrySet()){
            T key = e.getKey();
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.put(key,map.get(key) + 1);
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination = map;
    }
}
