package com.qin.session.servlet;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
