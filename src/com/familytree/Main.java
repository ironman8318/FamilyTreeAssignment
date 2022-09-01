package com.familytree;

import com.familytree.exception.PersonNotFoundException;
import com.familytree.result.DataResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FamilyTreeDriver driver = new FamilyTreeDriver();
        File file = new File("/home/ironman/IdeaProjects/family-tree/src/com/familytree/commands.txt");
        Scanner scanner = new Scanner(file);

        System.out.println("Welcome to the Family tree");
        while(true) {
            System.out.println("RelationShips");
            System.out.println("\t Supported Relations - Father , son , Daughter , Wife");
            System.out.println("Queries example");
            System.out.println("\t family-tree add person <name>");
            System.out.println("\t family-tree add relationship <name>");
            System.out.println("\t family-tree connect <name 1> as <relationship> of <name 2>");
            System.out.println("\t family-tree count sons of <name>");
            System.out.println("\t family-tree count daughters of <name>");
            System.out.println("\t family-tree count wives of <name>");
            System.out.println("\t family-tree father of <name>");
            System.out.println("\t family-tree mother of <name>");

            String commnad = "";

            while (scanner.hasNextLine()){
                commnad = scanner.nextLine();
                List<String> arguments = List.of(commnad.split(" "));


                if(arguments.get(0).equals("exit")) {
                    System.exit(1);
                }
                try{
                    DataResult res = driver.processCommand(arguments);
                    System.out.println();
                    System.out.println(res.message() + "\n" + res.getValue());
                }catch (IndexOutOfBoundsException i) {
                    System.out.println("Something is wrong with the command , kindly check and try again");
                    continue;
                }
            }

            break;







        }

    }
}
