package org.gradle;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.list.GrowthList;
 
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
        new GrowthList();
        List<Object> var = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
