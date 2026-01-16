package rvt;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;

public class TodoList{
    private static final String file_path  = "data/todolist.csv";
    public void add(String text){
        try (BufferedWriter writer = 
                new BufferedWriter(new FileWriter(file_path, true))){
            writer.write(text);
            writer.newLine();
        } catch (IOException e){
            System.out.println("Error adding message: " + e.getMessage());
        }
    }
    public void print(){
        try (Scanner scanner = new Scanner(new File(file_path))){
            int StrIndex = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    System.out.println(StrIndex + ": "+ line);
                    StrIndex ++;
            }
        }
        } catch (IOException e){
            System.out.println("Error outputting message: " + e.getMessage());
        }
    }
    public void remove(int index){
        try {
            List<String> lines = Files.readAllLines(Paths.get(file_path));
            if (index < 1 || index > lines.size()){
                System.out.println("No such a line.");
                return;
            }
            lines.remove(index - 1);
            Files.write(Paths.get(file_path), lines);
        } catch (IOException e){
            System.out.println("Error removing line: " + e.getMessage());
        }
    }
}