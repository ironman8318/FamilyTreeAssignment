package com.familytree.DAO;

import com.familytree.entity.Person;
import com.familytree.exception.PersonNotFoundException;

import java.util.List;

public interface DataStore {

    public boolean addRelationShip(String relation);

    public boolean checkRelationShip(String relation);
    public boolean addPerson(Person person);

    public Person getPerson(String name) ;

    public boolean addSon(String personName , String childName) throws PersonNotFoundException;

    public boolean addDaughter(String personName , String childName) throws PersonNotFoundException;
    public boolean setFather(String personName, String fatherName) throws PersonNotFoundException;
    public boolean setMother(String personName, String motherName) throws PersonNotFoundException;

    public boolean addWife(String personName , String spouseName ) throws PersonNotFoundException;

    public boolean addHusband(String personName , String spouseName ) throws PersonNotFoundException;

    public List<Person> getAllChildren(String personName) throws PersonNotFoundException;

    public List<Person> getAllSons(String personName) throws PersonNotFoundException;

    public List<Person> getAllDaughters(String personName) throws PersonNotFoundException;

    public List<Person> getAllWives(String personName) throws PersonNotFoundException;

    public List<Person> getAllHusbands(String personName) throws PersonNotFoundException;
    public Person getFather(String personName) throws PersonNotFoundException;
    public Person getMother(String personName) throws PersonNotFoundException;

    public int getTotalSonCount(String personName) throws PersonNotFoundException;

    public int getToTalDaughter(String personName) throws PersonNotFoundException;


    public int getTotalWives(String personName) throws PersonNotFoundException;
    public int getTotalHusbands(String personName) throws PersonNotFoundException;



}
