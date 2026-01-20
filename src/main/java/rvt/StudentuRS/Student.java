package rvt.StudentuRS;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private String registrationDate;

    public Student(String firstName, String lastName, String email, String personalCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getName(){
        return firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPersonalCode(){
        return personalCode;
    }
    public String registrationDate(){
        return registrationDate;
    }

    public void editName(String name){
        this.firstName = name;
    }
    public void editSurname(String surname){
        this.lastName = surname;
    }
    public void editEmail (String email){
        this.email = email;
    }


}