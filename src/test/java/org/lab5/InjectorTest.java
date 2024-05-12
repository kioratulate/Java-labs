package org.lab5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    @Test
    void inject_AB() {
        try{
            SomeBean sb = (new Injector<SomeBean>("/properties_AB")).inject(new SomeBean());
            sb.foo();
            assertEquals("A\r\nB", outputStreamCaptor.toString().trim());
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 IOException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    @Test
    void inject_AC() {
        try{
            SomeBean sb = (new Injector<SomeBean>("/properties_AC")).inject(new SomeBean());
            sb.foo();
            assertEquals("A\r\nC", outputStreamCaptor.toString().trim());
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 IOException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}