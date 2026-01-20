package rvt;
import java.util.Scanner;

public class UserInterface{
    private Scanner scanner;
    private TodoList list;

    public UserInterface(TodoList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }
    public void start(){
        while (true) {
            System.out.print("Command: ");
            String commandInput = scanner.nextLine().toLowerCase().trim();
            if (commandInput.equals("stop")) {
                return;
            }
            if (commandInput.equals("add")){
                System.out.print("To add: ");
                list.add(scanner.nextLine());
            } else if (commandInput.equals("list")){
                list.print();
            } else if (commandInput.equals("remove")){
                System.out.print("Which one is removed? ");
                try {
                    list.remove(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e){
                    System.out.println("Write a valid number.");
                }
            }
        }
    }
}