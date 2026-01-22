package rvt.StudentuRS;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Executor{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        Registration r = new Registration(fileHandler);

        r.register(scanner);
        System.out.println(fileHandler.readFile());
        
        
    }
}