package rvt.StudentuRS;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.*;

public class FileHandler {
    private String file_path = "studentDataBase.csv";

    public void fileWrite(ArrayList<Student> students){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true))){
            for (Student x : students){
                writer.write(x.toString());
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Error registering student.");
        }
    }   

    public void fileRemove(){

    }
 
}
