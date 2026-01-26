package rvt.StudentuRS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private final String file_path = "data/StudentData.csv";
    private final String[] headers = { "FirstName", "LastName", "Email", "PersonalCode", "RegistrationDate" };

    public FileHandler() {
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            File file = new File(file_path);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            if (!file.exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(String.join(",", headers));
                    writer.newLine();
                }
                System.out.println("Created new file with headers: " + file_path);
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public void writeToFile(List<StudentTemplate> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            writer.write(String.join(",", headers));
            writer.newLine();

            for (StudentTemplate s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public List<StudentTemplate> readFile() {
        List<StudentTemplate> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(file_path))) {
            boolean firstLine = true; 
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (firstLine) {
                    firstLine = false; 
                    continue;
                }
                if (!line.isBlank()) { 
                    students.add(StudentTemplate.readCSV(line)); 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return students;
    }

}