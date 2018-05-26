package com.ehcore.javaschool.lesson6reflection;

import java.lang.reflect.*;

public class GetterCounterImpl implements GetterCounter {
    @Override
    public int calcGetterCount(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        int count = 0;
        for(Method method : methods){
            if(method.isAnnotationPresent(Skip.class)) continue;
            if(isGetterMethod(method)) count++;
        }
        return count;
    }

    private boolean isGetterMethod(Method method){
        if(!method.getName().startsWith("get")) return false;
        if(method.getReturnType() == void.class) return false;
        if(method.getParameterTypes().length > 0) return false;
        return true;
    }
}
