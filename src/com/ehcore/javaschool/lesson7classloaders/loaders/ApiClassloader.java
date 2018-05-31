package com.ehcore.javaschool.lesson7classloaders.loaders;

import java.io.*;

/**
 * Данный класс загружает классы из пакета *.api
 */

public class ApiClassloader extends ClassLoader{
    public final String path;
    private final String pack = "com.ehcore.javaschool.lesson7classloaders.api";

    public ApiClassloader(){
        this.path = "out/production/SbTechJavaSchool/";
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.contains(pack)){
            return findClass(name);
        }else {
            return super.loadClass(name);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String newName = name.replace(".","\\");
        String fullName = path + newName + ".class";

        File file = new File(fullName);
        try(InputStream in = new FileInputStream(file)){
            long length = file.length();
            byte[] bytes = new byte[(int) length];
            in.read(bytes);
            Class<?> clazz = defineClass(name,bytes,0,bytes.length);
            return clazz;
        }catch (IOException exc){
            return super.findSystemClass(name);
        }
    }
}
