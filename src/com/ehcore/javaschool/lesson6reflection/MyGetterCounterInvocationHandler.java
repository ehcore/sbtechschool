package com.ehcore.javaschool.lesson6reflection;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class MyGetterCounterInvocationHandler implements InvocationHandler{

    GetterCounter delegate;

    public MyGetterCounterInvocationHandler(GetterCounter delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(delegate,args);
        return null;
    }

     /**
     * Возвращает кэшированый результат,
     * в случае, если по переданному аргументу нет
     * значения, возвращает -1
     * @param simpleNameClass принимает простое(без имени пакета) имя класса
     * @return возвращает количество методов геттеров в переданном классе
     */
    private int getCacheResult(String simpleNameClass) {
        Properties prop = new Properties();
        try(InputStream in = new FileInputStream("cache.properties")){
            prop.load(in);
            if(prop.containsKey(simpleNameClass)) return (int) prop.get(simpleNameClass);
        }catch (IOException exc){
            exc.printStackTrace();
        }
        return -1;
    }

    /**
     * Кладет кэшированый результат, в файл cache.properties
     * @param simpleNameClass принимает простое(без имени пакета) имя класса
     * @param count количество геттеров в данном классе
     */
    private void putCacheResult(String simpleNameClass,int count){
        Properties prop = new Properties();
        try(InputStream in = new FileInputStream("cache.properties")){
            prop.load(in);
            prop.put(simpleNameClass,count);
        }catch (IOException exc){
            exc.printStackTrace();
        }

    }
}
