package org.lab4;

import com.opencsv.CSVReader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A loader for Person objects from CSV files.
 *
 * @param <T> The type of List in which objects are stored.
 */
public class CSVLoaderPerson<T extends List<Person>> extends CSVLoader<T, Person> {

    /**
     * Constructs a CSVLoaderPerson with the specified path.
     *
     * @param list The existing list of Persons to which new Persons will be added.
     * @param path The relative path to the file.
     */
    public CSVLoaderPerson(T list, String path) {
        super(list, path);
    }

    /**
     * Constructs a CSVLoaderPerson with the specified path and separator.
     *
     * @param list      The existing list of Persons to which new Persons will be added.
     * @param path      The relative path to the file.
     * @param separator The separator character.
     */
    public CSVLoaderPerson(T list, String path, char separator) {
        super(list, path, separator);
    }

    /**
     * Constructs a CSVLoaderPerson with the specified reader.
     *
     * @param list      The existing list of Persons to which new Persons will be added.
     * @param csvReader The desired reader.
     */
    public CSVLoaderPerson(T list, CSVReader csvReader) {
        super(list, csvReader);
    }

    /**
     * Reads Person objects from CSV into the existing concrete implementation of List with Person.
     *
     * @param list The existing list.
     */
    @Override
    void csvToList(T list) {
        try {
            List<String[]> allData = csvReader.readAll();
            for (String[] personStr: allData){
                //id;name;gender;BirtDate(dd.MM.yyyy);Division;Salary
                int ID = Integer.parseInt(personStr[0]);
                String name = personStr[1];
                String gender = personStr[2];
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                Date birthDate = formatter.parse(personStr[3]);
                Division division = new Division(personStr[4].charAt(0));
                int salary = Integer.parseInt(personStr[5]);
                Person person = new Person(ID, name, gender, birthDate, division, salary);
                list.add(person);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
