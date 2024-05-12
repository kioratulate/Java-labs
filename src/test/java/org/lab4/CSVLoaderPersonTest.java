package org.lab4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVLoaderPersonTest {
    @Test
    void loadPersonfromCSV(){
            ArrayList<Person> persons = new ArrayList<>();
            CSVLoaderPerson<ArrayList<Person>> csvLoaderPerson = new CSVLoaderPerson<>(persons, "/foreign_names_short.csv", ';');
        assertFalse(persons.isEmpty());
    }
}