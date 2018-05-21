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
        try {
            return map.get(t);
        }catch(NullPointerException e){
            return 0;
        }
    }

    @Override
    public int remove(T t) {
        try {
            return map.remove(t);
        }catch (NullPointerException e){
            return 0;
        }
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
                map.put(key,e.getValue());
            }else{
                map.put(key,map.get(key) + e.getValue());
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
}
