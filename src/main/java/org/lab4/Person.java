package org.lab4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    int ID;
    String name;
    String gender;
    Date birthDate;
    Division division;
    int salary;


    public Person(int ID, String name, String gender, Date birthDate, Division division, int salary) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return "Person:"+
                " name="+name+
                " gender="+gender+
                " birthdate="+formatter.format(birthDate)+
                " division="+division+
                " salary="+salary;
    }
}