package rvt.StudentuRS;

import java.util.List;

public class Validator {
    
    public static boolean validateEmail(String email, List<StudentTemplate> studentsData){ //add date and time form checking

        for (StudentTemplate s : studentsData){
            if(s.getEmail().equalsIgnoreCase(email)){
                return false;
            }
        }
        return true;
    }
        public static boolean validatePersonalCode(String personalCode, List<StudentTemplate> studentsData){ //add xxxx--xxx checking

        for (StudentTemplate s : studentsData){
            if(s.getPersonalCode().equalsIgnoreCase(personalCode)){
                return false;
            }
        }
        return true;
    }
}
