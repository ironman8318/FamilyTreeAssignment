package com.familytree.DAO;

import com.familytree.entity.Person;
import com.familytree.exception.PersonNotFoundException;

import java.util.List;

public class MySQLDataStore implements DataStore{

    @Override
    public boolean addRelationShip(String relation) {
        return false;
    }

    @Override
    public boolean checkRelationShip(String relation) {
        return false;
    }

    @Override
    public boolean addPerson(Person person) {
        return false;
    }

    @Override
    public List<String> getSavedPerson() {
        return null;
    }

    @Override
    public List<String> getSavedRelation() {
        return null;
    }

    @Override
    public Person getPerson(String name) {
        return null;
    }

    @Override
    public boolean addSon(String personName, String childName) throws PersonNotFoundException {
        return false;
    }

    @Override
    public boolean addDaughter(String personName, String childName) throws PersonNotFoundException {
        return false;
    }

    @Override
    public boolean setFather(String personName, String fatherName) throws PersonNotFoundException {
        return false;
    }

    @Override
    public boolean setMother(String personName, String motherName) throws PersonNotFoundException {
        return false;
    }

    @Override
    public boolean addWife(String personName, String spouseName) throws PersonNotFoundException {
        return false;
    }

    @Override
    public boolean addHusband(String personName, String spouseName) throws PersonNotFoundException {
        return false;
    }


    @Override
    public List<Person> getAllChildren(String personName) throws PersonNotFoundException {
        return null;
    }

    @Override
    public List<Person> getAllSons(String personName) throws PersonNotFoundException {
        return null;
    }

    @Override
    public List<Person> getAllDaughters(String personName) throws PersonNotFoundException {
        return null;
    }

    @Override
    public List<Person> getAllWives(String personName) throws PersonNotFoundException {
        return null;
    }

    @Override
    public List<Person> getAllHusbands(String personName) throws PersonNotFoundException {
        return null;
    }


    @Override
    public Person getFather(String personName) throws PersonNotFoundException {
        return null;
    }

    @Override
    public Person getMother(String personName) throws PersonNotFoundException {
        return null;
    }

    @Override
    public int getTotalSonCount(String personName) throws PersonNotFoundException {
        return 0;
    }

    @Override
    public int getToTalDaughter(String personName) throws PersonNotFoundException {
        return 0;
    }

    @Override
    public int getTotalWives(String personName) throws PersonNotFoundException {
        return 0;
    }

    @Override
    public int getTotalHusbands(String personName) throws PersonNotFoundException {
        return 0;
    }
}
