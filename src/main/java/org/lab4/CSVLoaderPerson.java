package org.lab4;

import com.opencsv.CSVReader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Loader for Person objects from CSV files
 * @param <T> type of List in which objects are stored
 */
public class CSVLoaderPerson<T extends List<Person>> extends CSVLoader<T, Person> {


    public CSVLoaderPerson(T list, String path) {
        super(list, path);
    }

    public CSVLoaderPerson(T list, String path, char separator) {
        super(list, path, separator);
    }

    public CSVLoaderPerson(T list, CSVReader csvReader) {
        super(list, csvReader);
    }

    /**
     * Reading E class from CSV into existing concrete implementation of List
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
