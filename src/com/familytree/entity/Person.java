package com.familytree.entity;

import com.familytree.utils.SimpleKeyGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private int key;
    private String firstName;
    private String lastName;
    private Person mother;
    private Person father;
    private SimpleDate date;
    private Gender gender;
    private int id;
    private Map<String, List<Person>> relations;

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.key = new SimpleKeyGenerator().intkey();
        this.relations = new HashMap<>();
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relations = new HashMap<>();
    }

    public int getKey() {
        return key;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public SimpleDate getDate() {
        return date;
    }

    public void setDate(SimpleDate date) {
        this.date = date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, List<Person>> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, List<Person>> relations) {
        this.relations = relations;
    }

    public void addRelation(Person relative , String relation) {
        if(this.relations.containsKey(relation)) {
            this.relations.get(relation).add(relative);
        }else{
            List<Person> persons = new ArrayList<>();
            persons.add(relative);
            this.relations.put(relation,persons);
        }
    }
}
