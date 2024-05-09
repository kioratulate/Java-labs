package org.lab4;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Loader for specific classes from CSV files
 * @param <T> type of List in which objects are stored
 * @param <E> type of object
 */
public abstract class CSVLoader<T extends List<E>, E> {
    protected CSVReader csvReader;
    private CSVParser csvParser;
    private InputStreamReader fileReader;
    /**
     * relative path to file
     */
    private String path;
    /**
     * separator, default is ','
     */
    private char separator;

    /**
     * Constructor with path
     * @param list existing list to which objects will be added
     * @param path relative path to file
     */
    public CSVLoader(T list, String path) {
        this.path = path;
        try (InputStream in = getClass().getResourceAsStream(path)){
            if(in==null)
                throw new FileNotFoundException(path);
            fileReader = new InputStreamReader(in);
            csvParser = new CSVParser();
            csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1).build();

            csvToList(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * Constructor with path and specified separator
     * @param list existing list to which objects will be added
     * @param path relative path to file
     * @param separator separator
     */
    public CSVLoader(T list,String path,char separator) {
        this.separator = separator;
        this.path = path;
        try (InputStream in = getClass().getResourceAsStream(path)){
            if(in==null)
                throw new FileNotFoundException(path);
            fileReader = new InputStreamReader(in);
            csvParser = new CSVParserBuilder().withSeparator(separator).build();
            csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).withSkipLines(1).build();
            csvToList(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Constructor with desired reader
     * @param list existing list to which objects will be added
     * @param csvReader desired reader
     */
    public CSVLoader(T list,CSVReader csvReader) {
        this.csvReader = csvReader;
        separator = csvReader.getParser().getSeparator();
        csvToList(list);
    }

    /**
     * Reading E class from CSV into existing concrete implementation of List
     */
    abstract void csvToList(T list);

}
