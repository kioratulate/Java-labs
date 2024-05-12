package org.lab5;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
/**
 * A class responsible for injecting dependencies into annotated fields of a given class.
 * Dependencies are specified in a properties file and are instantiated based on the annotations.
 * @param <T> The type of the class instance whose fields are to be injected.
 */
public class Injector<T> {

    /**
     * The path to the properties file containing dependency mappings.
     */
    String propertiesPath;
    /**
     * Constructs an Injector object with the specified properties file path.
     *
     * @param propertiesPath The path to the properties file containing dependency mappings.
     */
    public Injector(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }
    /**
     * Constructs an Injector object with a default properties file path ("/properties").
     */
    public Injector() {
        propertiesPath = "/properties";
    }
    /**
     * Gets the current properties file path.
     *
     * @return The properties file path.
     */
    public String getPropertiesPath() {
        return propertiesPath;
    }
    /**
     * Sets the properties file path.
     *
     * @param propertiesPath The new properties file path.
     */
    public void setPropertiesPath(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }

    /**
     * Injects dependencies into the annotated fields of the given class instance.
     *
     * @param clazz The class instance whose fields are to be injected.
     * @return The class instance with injected dependencies.
     * @throws NoSuchMethodException     If a constructor for a dependency is not found.
     * @throws InvocationTargetException If a constructor invocation fails.
     * @throws InstantiationException    If a new instance of a dependency cannot be created.
     * @throws IllegalAccessException    If access to a field is denied.
     * @throws IOException               If an I/O error occurs while reading the properties file.
     * @throws ClassNotFoundException    If a class specified in the properties file is not found.
     * @throws NullPointerException     If the properties file is not found.
     */
    public T inject(T clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, NullPointerException {
        for (Field field: clazz.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(AutoInjectable.class)){
                Constructor<?> constructor = Class.forName(getInterfaceImplementationName(field.getType().getName())).getDeclaredConstructor();
                Object o = constructor.newInstance();
                boolean isAccessible = field.canAccess(clazz);
                field.setAccessible(true);
                field.set(clazz, o);
                field.setAccessible(isAccessible);
            }
        }
        return clazz;
    }
    /**
     * Retrieves the name of the class implementing the specified interface from the properties file.
     *
     * @param interfaceName The fully qualified name of the interface.
     * @return The fully qualified name of the implementing class.
     * @throws IOException If an I/O error occurs while reading the properties file.
     */
    private String getInterfaceImplementationName(String interfaceName) throws IOException {

        try (InputStream in = Main.class.getResourceAsStream(propertiesPath)) {
            Properties properties = new Properties();
            properties.load(in);
            return properties.getProperty(interfaceName);
        }
    }
}
