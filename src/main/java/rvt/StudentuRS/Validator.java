package rvt.StudentuRS;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern PERSONAL_CODE_PATTERN = Pattern.compile("^\\d{6}-\\d{5}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]{3,}$");
    public static boolean validateEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
    public static boolean validatePersonalCode(String email) {
        return PERSONAL_CODE_PATTERN.matcher(email).matches();
    }
    public static boolean validateName(String name){
        return NAME_PATTERN.matcher(name).matches();
    }
    public static boolean emailUniqueness(String email, List<StudentTemplate> studentsData) {
        for (StudentTemplate s : studentsData) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        return true;
    }
    public static boolean personalCodeUniqueness(String personalCode, List<StudentTemplate> studentsData) {
        for (StudentTemplate s : studentsData) {
            if (s.getPersonalCode().equalsIgnoreCase(personalCode)) {
                return false;
            }
        }
        return true;
    }
}
