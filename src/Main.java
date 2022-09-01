import com.familytree.driver.FamilyTreeDriver;
import com.familytree.result.DataResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FamilyTreeDriver driver = new FamilyTreeDriver();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Family tree");
        while (true) {
            System.out.println("RelationShips");
            System.out.println("\t Supported Relations - Father , son , Daughter , Wife , Husband");
            System.out.println("Queries example");
            System.out.println("\t family-tree show savedPerson");
            System.out.println("\t family-tree show savedRelation");
            System.out.println("\t family-tree add person <full Name>");
            System.out.println("\t family-tree add relationship <name>");
            System.out.println("\t family-tree connect <full name 1> as <relationship> of <full name 2>");
            System.out.println("\t family-tree count sons of <full name>");
            System.out.println("\t family-tree count daughters of <full name>");
            System.out.println("\t family-tree count wives of <full name>");
            System.out.println("\t family-tree count husbands of <full name>");
            System.out.println("\t family-tree father of <full name>");
            System.out.println("\t family-tree mother of <full name>");
            System.out.println("\t family-tree childrens of <full name>");
            System.out.println("\t family-tree wives of <full name>");
            System.out.println("\t family-tree husbands of <full name>");
            System.out.println("\t family-tree sons of <full name>");
            System.out.println("\t family-tree daughters of <full name>");
            System.out.println("To Exit");
            System.out.println("\t Type Exit");
            System.out.println("Enter the query ---");


            String command = "";

            command = scanner.nextLine();
            List<String> arguments = List.of(command.split(" "));


            if (arguments.get(0).toLowerCase().equals("exit")) {
                System.exit(1);
            }
            try {
                DataResult res = driver.processCommand(arguments);
                System.out.println();
                System.out.println(res.message() + "\n" + res.getValue());
            } catch (IndexOutOfBoundsException i) {
                System.out.println("Something is wrong with the command , kindly check and try again ,Note := first and last name is mandatoryfa");
                continue;
            }


        }

    }
}
