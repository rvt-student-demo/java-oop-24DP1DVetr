package rvt.StudentuRS;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler{
    private final String file_path = "data/StudentData.csv";
    public void writeToFile(List<StudentTemplate> student){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))){
            for (StudentTemplate s : student){
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
    public List<StudentTemplate> readFile(){
        List<StudentTemplate> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(file_path))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                students.add(StudentTemplate.readCSV(line));
            }
        } catch (Exception e){
            
        }
        return students;
    }
}