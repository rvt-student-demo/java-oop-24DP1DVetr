package rvt.StudentuRS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Registration {
    private List<StudentTemplate> students;
    private FileHandler filehandler;
    private Scanner scanner;

    public Registration(FileHandler filehandler, Scanner scanner) {
        this.students = filehandler.readFile();
        this.filehandler = filehandler;
        this.scanner = scanner;

    }

    public void registerStudent() {
        String firstName;
        do {
            System.out.print("  Student name: ");
            firstName = scanner.nextLine().trim();
            if (cancel(firstName)) {
                return;
            }
            if (checkEmpty(firstName)){
                continue;
            } else if (!Validator.validateName(firstName)){
                firstName = "";
                System.out.println("The name must not contain any numbers or special characters and must be at least 3 letters long.");
            }
        } while (firstName.isEmpty());

        String lastName;
        do {
            System.out.print("  Student last name: ");
            lastName = scanner.nextLine().trim();
            if (cancel(lastName)) {
                return;
            } 
            if (checkEmpty(lastName)){
                continue;
            } else if (!Validator.validateName(lastName)){
                lastName = "";
                System.out.println("The last name must not contain any numbers or special characters and must be at least 3 letters long.");
            }
        } while (lastName.isEmpty());

        String email;
        do {
            System.out.print("  Student email: ");
            email = scanner.nextLine().trim();
            if (cancel(email)) {
                return;
            }
            if (checkEmpty(email)) {
                continue;
            } else if (!Validator.validateEmail(email)) {
                System.out.println("Email is incorrect.");
                email = "";
            } else if (!Validator.emailUniqueness(email, students)) {
                System.out.println("Email is already used.");
                email = "";
            }
        } while (email.isEmpty());

        String personalCode;
        do {
            System.out.print("  Student personal code: ");
            personalCode = scanner.nextLine().trim();
            if (cancel(personalCode)) {
                return;
            }
            if (checkEmpty(personalCode)) {
                continue;
            } else if (!Validator.validatePersonalCode(personalCode)) {
                System.out.println("Personal code is incorrect.");
                personalCode = "";
            } else if (!Validator.personalCodeUniqueness(personalCode, students)) {
                System.out.println("Personal code is already used.");
                personalCode = "";
            }
        } while (personalCode.isEmpty());

        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = timeNow.format(formatter);

        StudentTemplate student = new StudentTemplate(firstName, lastName, email, personalCode, formattedDate);
        students.add(student);
        filehandler.writeToFile(students);
        System.out.println("Successfully added new student.\n");
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("There are no students.");
            return;
        }
        String[] headers = { "FirstName", "LastName", "Email", "PersonalCode", "RegistrationDate" };
        int numColumns = headers.length;
        int[] widths = new int[numColumns];

        for (int i = 0; i < numColumns; i++) {
            widths[i] = headers[i].length();
        }
        for (StudentTemplate s : students) {
            String[] row = s.toRow();
            for (int i = 0; i < numColumns; i++) {
                widths[i] = Math.max(widths[i], row[i].length());
            }
        }

        for (int i = 0; i < numColumns; i++) {
            System.out.printf("%-" + (widths[i] + 2) + "s", headers[i]);
        }
        System.out.println();
        for (int i = 0; i < numColumns; i++) {
            System.out.print("-".repeat(widths[i]));
            System.out.print("  ");
        }
        System.out.println();
        for (StudentTemplate s : students) {
            String[] row = s.toRow();
            for (int i = 0; i < numColumns; i++) {
                System.out.printf("%-" + (widths[i] + 2) + "s", row[i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void editStudent() {
        StudentTemplate s = findStudent();
        if (s == null) {
            return;
        }
        boolean editing = true;
        boolean editedAtLeastOnce = false;

        while (editing) {
            System.out.println("""
                    What do you want to edit?
                    Options: name | last name | email | cancel
                    """);
            String userOption = scanner.nextLine().toLowerCase().trim();
            switch (userOption) {
                case "name":
                    while (true) {
                        System.out.print("  Student new name: ");
                        String newName = scanner.nextLine().trim();
                        if (cancel(newName)) {
                            editing = false;
                            break;
                        } else if (newName.isEmpty()) {
                            System.out.println("You need to write something.");
                            continue;
                        } else if (!Validator.validateName(newName)){
                            System.out.println("The name must not contain any numbers or special characters and must be at least 3 letters long.");
                            continue;
                        }
                        s.editName(newName);
                        editedAtLeastOnce = true;
                        break;
                    }
                    break;
                case "last name":
                    while (true) {
                        System.out.print("  Student new last name: ");
                        String newLastName = scanner.nextLine().trim();
                        if (cancel(newLastName)) {
                            editing = false;
                            break;
                        } else if (newLastName.isEmpty()) {
                            System.out.println("You need to write something.");
                            continue;
                        } else if (!Validator.validateName(newLastName)){
                            System.out.println("The last name must not contain any numbers or special characters and must be at least 3 letters long.");
                            continue;
                        }
                        s.editLastName(newLastName);
                        editedAtLeastOnce = true;
                        break;
                    }
                    break;
                case "email":
                    while (true) {
                        System.out.print("  Student new email: ");
                        String newEmail = scanner.nextLine().trim();
                        if (cancel(newEmail)) {
                            editing = false;
                            break;
                        } else if (newEmail.isEmpty()) {
                            System.out.println("You need to write something.");
                            continue;
                        } else if (!Validator.validateEmail(newEmail)) {
                            System.out.println("Email is incorrect.");
                            continue;
                        } else if (!Validator.emailUniqueness(newEmail, students)) {
                            System.out.println("Email is already used.");
                            continue;
                        }
                        s.editEmail(newEmail);
                        editedAtLeastOnce = true;
                        break;
                    }
                    break;
                case "cancel":
                    System.out.println("Action canceled.");
                    editing = false;
                    break;
                default:
                    System.out.println("No such command.");
                    continue;
            }
            if (editedAtLeastOnce) {
                System.out.print("Do you want to edit another field? (y/n): ");
                String answer = scanner.nextLine().trim();

                while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                    System.out.print("Please enter 'y' or 'n': ");
                    answer = scanner.nextLine().trim();
                }
                if (answer.equalsIgnoreCase("y")) {
                    editing = true;
                } else {
                    editing = false;
                }
            }
        }
        if (editedAtLeastOnce) {
            filehandler.writeToFile(students);
            System.out.println("Student edited successfully.");
        } else {
            System.out.println("No changes were made.");
        }
    }

    public void removeStudent() {
        StudentTemplate s = findStudent();
        if (s == null) {
            return;
        }
        System.out.print("Are you sure you want to remove this student? (y/n): ");

        while (true) {
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Remove canceled.");
                return;
            } else if (answer.equalsIgnoreCase("y")) {
                break;
            }
            System.out.print("Please enter 'y' or 'n': ");
        }
        students.remove(s);
        filehandler.writeToFile(students);
        System.out.println("Student removed successfully.");
    }

    public StudentTemplate findStudent() {
        String personalCode;
        while (true) {
            System.out.print("Student personal code?: ");
            personalCode = scanner.nextLine().trim();

            if (cancel(personalCode)) {
                return null;
            }
            for (StudentTemplate s : students) {
                if (s.getPersonalCode().equals(personalCode)) {
                    String[] row = s.toRow();
                    int numColumns = row.length;
                    int[] widths = new int[numColumns];
                    for (int i = 0; i < numColumns; i++) {
                        widths[i] = Math.max(widths[i], row[i].length());
                    }
                    for (int i = 0; i < numColumns; i++) {
                        System.out.printf("%-" + (widths[i] + 2) + "s", row[i]);
                    }
                    System.out.println("\n");
                    return s;
                }
            }
            System.out.println("Personal code not found.");
        }
    }

    private boolean cancel(String text) {
        if (text.equalsIgnoreCase("cancel")) {
            System.out.println("Action canceled.");
            return true;
        }
        return false;
    }

    private boolean checkEmpty(String text) {
        if (text.isEmpty()) {
            System.out.println("Input is empty.");
            return true;
        }
        return false;
    }
}