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
        String simpleName = ((Class)args[0]).getSimpleName();
        int count = getCacheResult(simpleName);
        if(count == -1){
            count = (int)method.invoke(delegate,args);
            putCacheResult(simpleName,count);
            return count;
        }
        return count;
    }

     /**
     * Возвращает кэшированый результат, сохраненный в файле.
     * В случае, если по переданному имени класса нет
     * значения, возвращает -1.
     * @param simpleNameClass простое(без имени пакета) имя класса
     * @return количество методов геттеров в переданном классе
     */
    private int getCacheResult(String simpleNameClass) {
        Properties prop = new Properties();
        try(InputStream in = new FileInputStream(new File("cache.properties"))){//){
            prop.load(in);
            if(prop.containsKey(simpleNameClass)){
                try {
                    Integer result = Integer.parseInt((String) prop.get(simpleNameClass));
                    return result;
                }catch (NumberFormatException exc2){
                    return -1;
                }
            }
        }catch (IOException exc){
            exc.printStackTrace();
        }
        return -1;
    }

    /**
     * Сохраняет кэшированый результат в файл cache.properties.
     * Если файла нет, он создается.
     * @param simpleNameClass простое(без имени пакета) имя класса
     * @param count количество геттеров в данном классе
     */
    private void putCacheResult(String simpleNameClass,int count){
        Properties prop = new Properties();
        try(OutputStream out = new FileOutputStream(new File("cache.properties"),true)){
            prop.store(out,"");
            prop.put(simpleNameClass,""+count);

            prop.store(out,"");
        }catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
