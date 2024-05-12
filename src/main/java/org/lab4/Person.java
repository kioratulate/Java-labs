package org.lab4;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class representing a person.
 */
public class Person {
    /**
     * The ID of the person.
     */
    private final int ID;
    /**
     * The name of the person.
     */
    private final String name;
    /**
     * The gender of the person.
     */
    private final String gender;
    /**
     * The birthdate of the person.
     */
    private final Date birthDate;
    /**
     * The division the person belongs to.
     */
    private final Division division;
    /**
     * The salary of the person.
     */
    private final int salary;

    /**
     * Constructor for creating a person object.
     *
     * @param ID        The ID of the person.
     * @param name      The name of the person.
     * @param gender    The gender of the person.
     * @param birthDate The birthdate of the person.
     * @param division  The division the person belongs to.
     * @param salary    The salary of the person.
     */
    public Person(int ID, String name, String gender, Date birthDate, Division division, int salary) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birthDate = birthDate;
    }
    /**
     * Converts the Person object to a string representation.
     *
     * @return A string representing the Person object.
     */

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return "Person:"+
                "ID=" + ID +
                " name="+name+
                " gender="+gender+
                " birthdate="+formatter.format(birthDate)+
                " division="+division+
                " salary="+salary;
    }
}