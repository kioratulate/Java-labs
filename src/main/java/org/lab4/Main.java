package org.lab4;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<Person> persons = new ArrayList<>();
            CSVLoaderPerson<ArrayList<Person>> csvLoaderPerson = new CSVLoaderPerson<>(persons, "/foreign_names.csv", ';');

            for (var person: persons){
                System.out.println(person);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
}
}
