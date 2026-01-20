package rvt.StudentuRS;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    ArrayList<Student> students; 
    public Registration(){
        
    }
    public void register(Scanner scanner){
            System.out.print("Student firstname: ");
            String firstName = scanner.nextLine();
            System.out.print("Student lastname: ");
            String lastName = scanner.nextLine();
            System.out.print("Student email: ");
            String email = scanner.nextLine();
            System.out.print("Student personal code: ");
            String personalCode = scanner.nextLine();
            Student student = new Student(firstName, lastName, email, personalCode);
            students.add(student);
            FileHandler.fileWrite(students);
    }
    public void show(){

    }
}
