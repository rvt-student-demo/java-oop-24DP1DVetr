package rvt.StudentuRS;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration{
    private List<StudentTemplate> students;
    private FileHandler filehandler;
    public Registration(FileHandler filehandler){
        this.students = filehandler.readFile();
        this.filehandler = filehandler;

    }
    public void register(Scanner scanner){
        List<StudentTemplate> s = new ArrayList<>();
        //text.replaceAll("\\s+", "");
        String firstName;
        do {
            System.out.print("Student name: ");
            firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()){
                System.out.println("You need to write something.");
            }
        } while (firstName.isEmpty());
        
        String lastName;
        do {
            System.out.print("Student last name: ");
            lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()){
                System.out.println("You need to write something.");
            }
        } while (lastName.isEmpty());
            
        String email; 
        do {
            System.out.print("Student email: ");
            email = scanner.nextLine();
            if (email.isEmpty()){
                System.out.println("You need to write something.");
            }
            else if (!Validator.validateEmail(email, students)){
                System.out.println("Email is already used or is incorrect.");
                email = "";
            }
        } while (email.isEmpty());

        String personalCode; 
        do {
            System.out.print("Student personal code: ");
            personalCode = scanner.nextLine();
            if (personalCode.isEmpty()){
                System.out.println("You need to write something.");
            }
            else if (!Validator.validateEmail(email, students)){
                System.out.println("Personal code is already used or is incorrect.");
                personalCode = "";
            }
        } while (personalCode.isEmpty());
        StudentTemplate student = new StudentTemplate(firstName, lastName, email, personalCode);
        s.add(student);
        filehandler.writeToFile(s);
        }
    }
