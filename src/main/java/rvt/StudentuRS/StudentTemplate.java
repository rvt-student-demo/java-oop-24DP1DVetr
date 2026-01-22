package rvt.StudentuRS;
import java.time.LocalDateTime;

public class StudentTemplate{
    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private String registrationDate;

    public StudentTemplate(String firstName, String lastName, String email, String personalCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
    }

    public String toString(){
        return firstName + "," + lastName + "," + email + "," + personalCode + "," + registrationDate;
    }
    public String Name(){
        return firstName + lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPersonalCode(){
        return personalCode;
    }
    public static StudentTemplate readCSV(String line){
        String[] parts = line.split(",");
        StudentTemplate student = new StudentTemplate(parts[0], parts[1], parts[2], parts[3]);
        return student;
    }
}