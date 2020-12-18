package com.example.repository;

public class Repository {

    private Integer id;
    private String name;
    private String full_name;
    private Owner owner;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public Owner getOwner() {
        return owner;
    }
}

