package rvt.StudentuRS;
import java.util.Scanner;

public class UI {
    public void launch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to SRS (Student Registration System)\n Following commands: register, show, remove, edit, exit");
        while (true){
            System.out.print("Command: ");
            String userInput = scanner.nextLine().toLowerCase().trim();
            switch (userInput){
                case "register":
                    break;
                case "show":
                    break;
                case "remove":
                    break;
                case "edit":
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("No such a command. Try again.");
            }
        }
    }
}
