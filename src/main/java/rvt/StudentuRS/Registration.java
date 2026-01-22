package rvt.StudentuRS;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration{
    private List<StudentTemplate> students;
    private FileHandler filehandler;
    private Scanner scanner;
    public Registration(FileHandler filehandler, Scanner scanner){
        this.students = filehandler.readFile();
        this.filehandler = filehandler;
        this.scanner = scanner;

    }
    public void registerStudent(Scanner scanner){
        List<StudentTemplate> s = new ArrayList<>();
        String firstName;
        do {
            System.out.print("  Student name: ");
            firstName = scanner.nextLine().replaceAll("\\s+", "");
            if (firstName.isEmpty()){
                System.out.println("You need to write something.");
            }
        } while (firstName.isEmpty());
        
        String lastName;
        do {
            System.out.print("  Student last name: ");
            lastName = scanner.nextLine().replaceAll("\\s+", "");
            if (lastName.isEmpty()){
                System.out.println("You need to write something.");
            }
        } while (lastName.isEmpty());
            
        String email; 
        do {
            System.out.print("  Student email: ");
            email = scanner.nextLine().replaceAll("\\s+", "");
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
            System.out.print("  Student personal code: ");
            personalCode = scanner.nextLine().replaceAll("\\s+", "");
            if (personalCode.isEmpty()){
                System.out.println("You need to write something.");
            }
            else if (!Validator.validatePersonalCode(personalCode, students)){
                System.out.println("Personal code is already used or is incorrect.");
                personalCode = "";
            }
        } while (personalCode.isEmpty());
        StudentTemplate student = new StudentTemplate(firstName, lastName, email, personalCode);
        s.add(student);
        filehandler.writeToFile(s);
        System.out.println("Successfuly added new student.\n");
        }

        public void showStudents(){
            try {
                int numColumns = students.get(0).toRow().length;
                int[] widths = new int[numColumns];
                System.out.println("\nStudent list:");
                for (StudentTemplate s : students){
                    String[] row = s.toRow();
                    for (int i = 0; i < numColumns; i++){
                        widths[i] = Math.max(widths[i], row[i].length());
                    }   
                }
                for (StudentTemplate s : students){
                    String[] row = s.toRow();
                    for (int i = 0; i < numColumns; i++){
                        System.out.printf("%-" + (widths[i] + 2) + "s", row[i]);
                    }   
                    System.out.println();
                }
                System.out.println();
            } catch (IndexOutOfBoundsException e){
                System.out.println("There is no students.");
            }
        }
        public void editStudent(){
            
        }

        public void removeStudent(){

        }
        public void findStudent(){ // Needs to be done
            String personalCode;
            boolean exit = false;
            do {
                System.out.print("Student personal code?: ");
                personalCode = scanner.nextLine().toLowerCase();
                if(!personalCode.equals("exit") || !Validator.validatePersonalCode(personalCode, students)){
                    for (StudentTemplate s : students){
                        String[] row = s.toRow();
                        if(row[3].equals(personalCode)){ // Need to edit so it can check headers
                            
                        } 
                    }
                } else {
                    exit = true;
                }
            } while (!exit);
        }
    }
