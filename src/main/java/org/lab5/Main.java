package org.lab5;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
/**
 * The main class of the application responsible for initiating the dependency injection process.
 * It creates an instance of the Injector class, injects dependencies into a SomeBean object,
 * and then executes the foo method of SomeBean.
 */
public class Main {
    /**
     * The main method of the application.
     * It instantiates an Injector object, injects dependencies into a SomeBean object,
     * and then calls the foo method of SomeBean.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try{
            // Create an instance of SomeBean and inject dependencies
            SomeBean sb = (new Injector<SomeBean>()).inject(new SomeBean());
            // Execute the foo method
            sb.foo();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 IOException | ClassNotFoundException | NullPointerException e) {
            // Print any exceptions that occur during the process
            e.printStackTrace();
        }
    }
}
