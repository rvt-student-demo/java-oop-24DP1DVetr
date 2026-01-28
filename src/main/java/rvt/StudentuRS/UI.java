package rvt.StudentuRS;

import java.util.Scanner;


public class UI {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        Registration registration = new Registration(fileHandler, scanner);

        System.out.println("\tWelcome to SRS (Student Registration System)\n\t\t\tCommands: \n\t  register  show  find  remove  edit  exit");
        while (true) {
            System.out.print("Command: ");
            String userCommand = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
            switch (userCommand) {
                case "register":
                    registration.registerStudent();
                    break;
                case "show":
                    registration.showStudents();
                    break;
                case "remove":
                    registration.removeStudent();
                    break;
                case "edit":
                    registration.editStudent();
                    break;
                case "find":
                    registration.findStudent();
                    break;
                case "help":
                    System.out.println("  Commands: register  show  find  remove  edit  exit");
                    break;
                case "exit":
                    System.out.println("Exiting SRS....");
                    return;
                default:
                    System.out.println("No such command.");
                    break;
            }
        }
    }
}
