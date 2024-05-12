package org.lab4;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Represents a division.
 */
public class Division {
    /**
     * The ID of the division.
     */
    private int ID;
    /**
     * The name of the division.
     */
    private final Character name;

    /**
     * A map storing division names and their corresponding IDs.
     */
    private final static HashMap<Character, Integer> divisions = new HashMap<>();

    /**
     * A set preventing division IDs from repeating.
     */
    private final static HashSet<Integer> IDs = new HashSet<>();

    /**
     * Constructs a division with the given name.
     *
     * @param name The name of the division.
     */
    public Division(Character name) {
        this.name = name;
        if (!divisions.containsKey(name))
        {
            int id = (int)(Math.random()*1000);
            while (IDs.contains(id))
                id = (int)(Math.random()*1000);
            divisions.put(name,  id);
            IDs.add(id);
            ID = id;

        }
        this.ID = divisions.get(name);
    }

    /**
     * Converts the Division object to a string representation.
     *
     * @return A string representing the Division object.
     */
    @Override
    public String toString() {
        return "Division:"+
                " ID="+ID+
                " name="+name;
    }
}
