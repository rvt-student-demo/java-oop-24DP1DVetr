package rvt.StudentuRS;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    
    public static boolean validateEmail(String email, List<StudentTemplate> studentsData){

        for (StudentTemplate s : studentsData){
            if(s.getEmail().equalsIgnoreCase(email)){
                return false;
            }
        }
        return true;
    }
        public static boolean validatePersonalCode(String personalCode, List<StudentTemplate> studentsData){

        for (StudentTemplate s : studentsData){
            if(s.getEmail().equalsIgnoreCase(personalCode)){
                return false;
            }
        }
        return true;
    }
        public static boolean validateName(String email, List<StudentTemplate> studentsData){

        for (StudentTemplate s : studentsData){
            if(s.getEmail().equalsIgnoreCase(email)){
                return false;
            }
        }
        return true;
    }
    
}
