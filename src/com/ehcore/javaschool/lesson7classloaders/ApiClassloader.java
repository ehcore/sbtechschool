package com.ehcore.javaschool.lesson7classloaders;

import java.io.*;

public class ApiClassloader extends ClassLoader{
    private String path;

    public ApiClassloader(String path){
        this.path = path;
    }

    public ApiClassloader(){
      //  System.out.println("hello from api class loader 1");
        //this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
   //     if(name.equals("com.ehcore.javaschool.lesson7classloaders.app.App")){
            return findClass(name);
//        }else {
//            return super.loadClass(name);
//        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

       // System.out.println("hello from api class loader 2");
        String newName = name.replace(".","\\");
        //System.out.println();

        String fullName = path + newName + ".class";
     //   System.out.println(fullName);

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



        //return super.findClass(name);
    }
}
