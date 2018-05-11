package com.ehcore.javaschool.lesson2;

public class PersonTester {
    public static void main(String[] args) {
        System.out.println("******Max and Clava, not married*******");
        Person p1 = new Person(true, "Max");
        Person p2 = new Person(false, "Clava");

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("******Max and Clava married*******");

        p1.marry(p2);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("*****Hello Arny*******");

        Person p3 = new Person(true, "Arnold");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("*****Arny tries to marry Max*******");

        if(!p3.marry(p1)){
            System.out.println("fail: they are of the same gender");
        }

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("*****Clava tries to marry Max***********");

        if(!p2.marry(p1)){
            System.out.println("fail: they are already married");
        };

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("****Hello Dina******");

        Person p4 = new Person(false, "Dina");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("****Dina marries Max******");

        p4.marry(p1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("*****Clava marries Arny******");

        p2.marry(p3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
