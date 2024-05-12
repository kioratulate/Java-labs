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
 * A loader for specific classes from CSV files.
 *
 * @param <T> The type of List in which objects are stored.
 * @param <E> The type of object.
 */
public abstract class CSVLoader<T extends List<E>, E> {
    /**
     * The CSVReader used for loading CSV.
     */
    protected CSVReader csvReader;
    /**
     * The CSVParser used for loading CSV.
     */
    private CSVParser csvParser;
    /**
     * The InputStreamReader used for loading CSV.
     */
    private InputStreamReader inputStreamReader;
    /**
     * The relative path to the file.
     */
    private String path;
    /**
     * The separator character. The default value is ','.
     */
    private char separator;

    /**
     * Constructs a CSVLoader with the specified path.
     *
     * @param list The existing list to which objects will be added.
     * @param path The relative path to the file.
     */
    public CSVLoader(T list, String path) {
        this.path = path;
        try (InputStream in = getClass().getResourceAsStream(path)){
            if(in==null)
                throw new FileNotFoundException(path);
            inputStreamReader = new InputStreamReader(in);
            csvParser = new CSVParser();
            csvReader = new CSVReaderBuilder(inputStreamReader).withCSVParser(csvParser).withSkipLines(1).build();

            csvToList(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * Constructs a CSVLoader with the specified path and separator.
     *
     * @param list      The existing list to which objects will be added.
     * @param path      The relative path to the file.
     * @param separator The separator character.
     */
    public CSVLoader(T list,String path,char separator) {
        this.separator = separator;
        this.path = path;
        try (InputStream in = getClass().getResourceAsStream(path)){
            if(in==null)
                throw new FileNotFoundException(path);
            inputStreamReader = new InputStreamReader(in);
            csvParser = new CSVParserBuilder().withSeparator(separator).build();
            csvReader = new CSVReaderBuilder(inputStreamReader).withCSVParser(csvParser).withSkipLines(1).build();
            csvToList(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Constructs a CSVLoader with the specified reader.
     *
     * @param list      The existing list to which objects will be added.
     * @param csvReader The desired reader.
     */
    public CSVLoader(T list,CSVReader csvReader) {
        this.csvReader = csvReader;
        separator = csvReader.getParser().getSeparator();
        csvToList(list);
    }

    /**
     * Reads E class from CSV into the existing concrete implementation of List.
     *
     * @param list The existing list.
     */
    abstract void csvToList(T list);

}
