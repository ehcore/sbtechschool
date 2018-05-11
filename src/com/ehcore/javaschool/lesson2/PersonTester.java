package com.ehcore.javaschool.lesson2;

public class PersonTester {

    public static void main(String[] args) {
        Person p1 = new Person(true,"Max");
        Person p2 = new Person(false, "Clava");
        p1.marry(p2);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("****************");

        Person p3 = new Person(true,"Arnold");
        p3.marry(p1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("****************");

        Person p4 = new Person(false, "Dina");
        p4.marry(p1);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("****************");

        p2.marry(p3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

    }

}
