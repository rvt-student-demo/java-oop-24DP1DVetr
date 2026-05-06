package rvt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private static final String file_path = "data/todolist.csv";
    private ArrayList<String[]> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
        loadFromFile();
    }

    
    public void add(String text) {
        
    }
    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            String[] task = tasks.get(i);
            System.out.println("Id: " + task[0] + " | Tasks: " + task[1]);
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task at index " + index + " removed.");
        } else {
            System.out.println("Error: Index out of bounds.");
        }
    }
    
    private void WriteToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))) {
            
        } catch (IOException e) {
            System.out.println("Error adding message: " + e.getMessage());
        }
    }
    
    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                tasks.add(parts);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}