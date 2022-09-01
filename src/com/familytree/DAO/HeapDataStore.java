package com.familytree.DAO;

import com.familytree.entity.Person;
import com.familytree.exception.PersonNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeapDataStore implements DataStore{

    private Map<String, Person> personStorage;
    private Map<String, Boolean> relationShipStorage;

    public HeapDataStore() {
        this.personStorage = new HashMap<>();
        this.relationShipStorage = new HashMap<>();
    }

    @Override
    public boolean addRelationShip(String relation) {
        relationShipStorage.put(relation , true);
        return true;
    }

    @Override
    public boolean checkRelationShip(String relation) {
        if(relationShipStorage.get(relation.toLowerCase()) == null || !relationShipStorage.get(relation)) {
            return false;
        };
        return true;
    }

    @Override
    public boolean addPerson(Person person) {
        personStorage.put(person.getFullName().toLowerCase() , person);
        return true;
    }

    @Override
    public List<String> getSavedPerson() {
        return new ArrayList<String>(personStorage.keySet());
    }
    @Override
    public List<String> getSavedRelation() {
        return new ArrayList<String>(relationShipStorage.keySet());
    }

    @Override
    public Person getPerson(String name) {
        return personStorage.get(name.toLowerCase());
    }

    @Override
    public boolean addSon(String personName, String childName) throws PersonNotFoundException {

        Person person = getPerson(personName);
        Person children = getPerson(childName);

        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");
        if(children == null) throw new PersonNotFoundException("Son Info doesn't exists");

        person.addRelation(children , "son");
        return true;
    }

    @Override
    public boolean addDaughter(String personName, String childName) throws PersonNotFoundException {

        Person person = getPerson(personName);
        Person children = getPerson(childName);

        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");
        if(children == null) throw new PersonNotFoundException("Daughter Info doesn't exists");

        person.addRelation(children , "daughter");
        return true;
    }


    @Override
    public boolean setFather(String personName, String fatherName) throws PersonNotFoundException {
        Person person = getPerson(personName);
        Person father = getPerson(fatherName);
        if(person == null) throw new PersonNotFoundException("person Info doesn't exists");
        if(father == null) throw new PersonNotFoundException("father Info doesn't exists");

        person.setFather(father);

        return true;
    }

    @Override
    public boolean setMother(String personName, String motherName) throws PersonNotFoundException {
        Person person = getPerson(personName);
        Person mother = getPerson(motherName);
        if(person == null) throw new PersonNotFoundException("person Info doesn't exists");
        if(mother == null) throw new PersonNotFoundException("mother Info doesn't exists");

        person.setMother(mother);

        return true;
    }

    @Override
    public boolean addWife(String personName, String spouseName) throws PersonNotFoundException {
        Person person = getPerson(personName);
        Person spouse = getPerson(spouseName);

        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");
        if(spouse == null) throw new PersonNotFoundException("Wife Info doesn't exists");

        person.addRelation(spouse , "wife");
        return true;
    }

    @Override
    public boolean addHusband(String personName, String spouseName) throws PersonNotFoundException {
        Person person = getPerson(personName);
        Person spouse = getPerson(spouseName);

        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");
        if(spouse == null) throw new PersonNotFoundException("Husband Info doesn't exists");

        person.addRelation(spouse , "husband");
        return true;
    }

    @Override
    public List<Person> getAllChildren(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);


        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        List<Person> childrens =  getAllSons(personName);

        if(childrens == null){
            childrens =  getAllDaughters(personName);
        }else{
            childrens = new ArrayList<>(childrens);
            List<Person> daughters = getAllDaughters(personName);
            if(daughters != null) {
                childrens. addAll(daughters);
            }
        }


        return childrens;

    }

    @Override
    public List<Person> getAllSons(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);


        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        List<Person> childrens =  person.getRelations().get("son");

        return childrens;
    }

    @Override
    public List<Person> getAllDaughters(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);


        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        List<Person> childrens =  person.getRelations().get("daughter");

        return childrens;
    }

    @Override
    public List<Person> getAllHusbands (String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);

        if(person == null) throw new PersonNotFoundException("Person's Info doesn't exists");

        return person.getRelations().get("husband");

    }

    @Override
    public List<Person> getAllWives (String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);

        if(person == null) throw new PersonNotFoundException("Person's Info doesn't exists");

        return person.getRelations().get("wife");

    }

    @Override
    public Person getFather(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);

        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        return person.getFather();
    }

    @Override
    public Person getMother(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);

        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        return person.getMother();
    }

    @Override
    public int getTotalSonCount(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);


        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        if(person.getRelations().containsKey("son")) {
            return person.getRelations().get("son").size();
        }
        return 0;
    }

    @Override
    public int getToTalDaughter(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);


        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        if(person.getRelations().containsKey("daughter")) {
            return person.getRelations().get("daughter").size();
        }
        return 0;
    }



    @Override
    public int getTotalWives(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);


        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        if(person.getRelations().containsKey("wife")) {
            return person.getRelations().get("wife").size();
        }
        return 0;
    }

    @Override
    public int getTotalHusbands(String personName) throws PersonNotFoundException {
        Person person = getPerson(personName);


        if(person == null) throw new PersonNotFoundException("Person Info doesn't exists");

        if(person.getRelations().containsKey("husband")) {
            return person.getRelations().get("husband").size();
        }
        return 0;
    }
}
