package org.lab4;



import java.util.ArrayList;

/**
 * Main class for loading and displaying persons from a CSV file.
 */
public class Main {
    /**
     * Main method to load and display persons from a CSV file.
     *
     * @param args Command line arguments (unused).
     */
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
