package org.lab4;

import java.util.HashMap;
import java.util.HashSet;

public class Division {
    int ID;
    Character name;
    /**
     * All divisions have generated randomly, so their id stored in hashmap
     */
    static HashMap<Character, Integer> divisions = new HashMap<>();

    /**
     * Set preventing ids from repeating
     */
    static HashSet<Integer> IDs = new HashSet<>();
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

    @Override
    public String toString() {
        return "Division:"+
                " ID="+ID+
                " name="+name;
    }
}
