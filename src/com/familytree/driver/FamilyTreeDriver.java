package com.familytree.driver;

import com.familytree.DAO.DataStore;
import com.familytree.DAO.HeapDataStore;
import com.familytree.entity.Person;
import com.familytree.exception.PersonNotFoundException;
import com.familytree.result.DataError;
import com.familytree.result.DataResult;
import com.familytree.result.DataSuccess;

import java.util.List;


public class FamilyTreeDriver {
    public DataStore store;

    public FamilyTreeDriver() {
        this.store = new HeapDataStore();
    }

    public DataResult processCommand(List<String> arguments) throws IndexOutOfBoundsException {
        if (arguments.size() < 3) return new DataError("Invalid command");
        if (!arguments.get(0).equals("family-tree")) return new DataError("Invalid command,check syntax again");


        switch (arguments.get(1).toLowerCase()) {
            case "add":
                switch (arguments.get(2).toLowerCase()) {
                    case "relationship":
                        return addRelationToStore(arguments.get(3));

                    case "person":
                        return addPersonToStore(arguments.get(3), arguments.get(4));

                }
                break;
            case "show":
                switch (arguments.get(2).toLowerCase()) {
                    case "savedperson":
                        return getSavedPerson();

                    case "savedrelation":
                        return getSavedRelation();

                }
                break;

            case "count":
                switch (arguments.get(2).toLowerCase()) {
                    case "sons":
                        return countRelatives(arguments.get(4), arguments.get(5), "sons");
                    case "daughters":
                        return countRelatives(arguments.get(4), arguments.get(5), "daughters");
                    case "husbands":
                        return countRelatives(arguments.get(4), arguments.get(5), "husbands");
                    case "wives":
                        return countRelatives(arguments.get(4), arguments.get(5), "wives");
                }
                break;
            case "father":
                return getRelative(arguments.get(3), arguments.get(4), "father");

            case "mother":
                return getRelative(arguments.get(3), arguments.get(4), "mother");

            case "childrens":
                return getRelatives(arguments.get(3), arguments.get(4), "childrens");
            case "wives":
                return getRelatives(arguments.get(3), arguments.get(4), "wives");
            case "husbands":
                return getRelatives(arguments.get(3), arguments.get(4), "husbands");
            case "sons":
                return getRelatives(arguments.get(3), arguments.get(4), "sons");
            case "daughters":
                return getRelatives(arguments.get(3), arguments.get(4), "daughters");

            case "connect":
                String relationShip = arguments.get(5);

                return addRelation(arguments.get(7), arguments.get(8), arguments.get(2), arguments.get(3), relationShip);


        }

        return new DataSuccess("Success");
    }

    public DataResult addRelationToStore(String relation) {
        if (relation.length() > 0) {
            store.addRelationShip(relation.toLowerCase());
        } else {
            return new DataError("Empty/No relationShip given");
        }

        return new DataSuccess("Success", "RelationShip Added Successfully");
    }

    public DataResult addPersonToStore(String firstName, String lastName) {
        if (firstName.length() > 0 && lastName.length() > 0) {
            store.addPerson(new Person(firstName, lastName));
        } else {
            return new DataError("Empty/No firstName lastName given,both are needed");
        }

        return new DataSuccess("Success", "Person Added Successfully");
    }


    public DataResult countRelatives(String firstName, String lastName, String relation) {
        if (firstName.length() > 0 && lastName.length() > 0) {
            int value = 0;
            try {
                String name = firstName + " " + lastName;
                switch (relation) {
                    case "sons":
                        value = store.getTotalSonCount(name);
                        break;
                    case "daughters":
                        value = store.getToTalDaughter(name);
                        break;
                    case "wives":
                        value = store.getTotalWives(name);
                        break;
                    case "husbands":
                        value = store.getTotalHusbands(name);
                        break;
                    default:
                        return new DataError("Invalid/UnSupported relation in count command");
                }
            } catch (PersonNotFoundException p) {
                return new DataError(p.getMessage());
            }
            return new DataSuccess("Success", "totalCount = " + value);
        } else {
            return new DataError("Invalid Command/firsName or lastName is not given , both are needed");
        }
    }

    public DataResult getRelative(String firstName, String lastName, String relation) {
        if (firstName.length() > 0 && lastName.length() > 0) {
            Person person;
            try {
                String name = firstName + " " + lastName;
                switch (relation) {
                    case "father":
                        person = store.getFather(name);
                        break;
                    case "mother":
                        person = store.getMother(name);
                        break;
                    default:
                        return new DataError("Invalid/UnSupported  relation in  command");
                }
            } catch (PersonNotFoundException p) {
                return new DataError(p.getMessage());
            }
            if (person == null) {
                return new DataError("Relative doesn't exists");
            }
            return new DataSuccess("Success", "" + person.getFullName());
        } else {
            return new DataError("Invalid Command/firsName or lastName is not given,both are needed");
        }
    }

    public DataResult getRelatives(String firstName, String lastName, String relation) {
        if (firstName.length() > 0 && lastName.length() > 0) {
            List<Person> person;
            try {
                String name = firstName + " " + lastName;
                switch (relation) {
                    case "childrens":
                        person = store.getAllChildren(name);
                        break;
                    case "wives":
                        person = store.getAllWives(name);
                        break;
                    case "husbands":
                        person = store.getAllHusbands(name);
                        break;
                    case "sons":
                        person = store.getAllSons(name);
                        break;
                    case "daughters":
                        person = store.getAllDaughters(name);
                        break;
                    default:
                        return new DataError("Invalid/UnSupported  relation in  command");
                }
            } catch (PersonNotFoundException p) {
                return new DataError(p.getMessage());
            }

            if (person == null || person.size() == 0) {
                return new DataSuccess("Success", "" + "No relatives found");
            }
            String data = "Here is the list\n";

            for (int i = 0; i < person.size(); i++) {
                data += String.format("%d. %s\n", i + 1, person.get(i).getFullName());
            }


            return new DataSuccess("Success", "" + data);
        } else {
            return new DataError("Invalid Command/firsName or lastName is not given,both are needed");
        }
    }

    public DataResult setRelative(String personFirstName, String personLastName, String relativeFirstName, String relativeLastName, String relation) {
        if (personFirstName.length() > 0 && personLastName.length() > 0 && relativeFirstName.length() > 0 && relativeLastName.length() > 0) {
            boolean b = false;
            try {
                String personName = personFirstName + " " + personLastName;
                String relativeName = relativeFirstName + " " + relativeLastName;
                switch (relation) {
                    case "father":
                        b = store.setFather(personName, relativeName);
                        break;
                    case "mother":
                        b = store.setMother(personName, relativeName);
                        break;
                    default:
                        return new DataError("Invalid/UnSupported  relation in command");
                }
            } catch (PersonNotFoundException p) {
                return new DataError(p.getMessage());
            }
            return new DataSuccess("Success", "");
        } else {
            return new DataError("Invalid Command/firsName or lastName is not given");
        }

    }


    public DataResult addRelation(String personFirstName, String personLastName, String relativeFirstName, String relativeLastName, String relation) {

        if (!store.checkRelationShip(relation)) {
            return new DataError("Invalid/UnSupported  relationship ");
        }

        if (personFirstName.length() > 0 && personLastName.length() > 0 && relativeFirstName.length() > 0 && relativeLastName.length() > 0) {
            boolean set = false;
            try {
                String personName = personFirstName + " " + personLastName;
                String relativeName = relativeFirstName + " " + relativeLastName;

                switch (relation) {
                    case "son":
                        set = store.addSon(personName, relativeName);
                        break;
                    case "daughter":
                        set = store.addDaughter(personName, relativeName);
                        break;
                    case "wife":
                        set = store.addWife(personName, relativeName);
                        break;
                    case "husband":
                        set = store.addHusband(personName, relativeName);
                        break;
                    case "father":
                        set = store.setFather(personName, relativeName);
                        break;
                    case "mother":
                        set = store.setMother(personName, relativeName);
                        break;
                    default:
                        return new DataError("Invalid/UnSupported  relation in command");

                }
                if (!set) {
                    return new DataError("Not able to set");
                }
            } catch (PersonNotFoundException p) {
                return new DataError(p.getMessage());
            }
            return new DataSuccess("Success", "Connection added Successfully");
        } else {
            return new DataError("Invalid Command/firsName or lastName is not given");
        }

    }

    public DataResult getSavedPerson() {
        List<String> list = store.getSavedPerson();
        if (list == null || list.size() == 0) {
            return new DataSuccess("Success", "" + "No saved person found");
        }
        String data = "Here is the list\n";

        for (int i = 0; i < list.size(); i++) {
            data += String.format("%d. %s\n", i + 1, list.get(i));
        }

        return new DataSuccess("Success", data);
    }

    public DataResult getSavedRelation() {
        List<String> list = store.getSavedRelation();
        if (list == null || list.size() == 0) {
            return new DataSuccess("Success", "" + "No saved person found");
        }
        String data = "Here is the list\n";

        for (int i = 0; i < list.size(); i++) {
            data += String.format("%d. %s\n", i + 1, list.get(i));
        }

        return new DataSuccess("Success", data);
    }
}

