package rvt.StudentuRS;

public class StudentTemplate {
    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private String registrationDate;

    public StudentTemplate(String firstName, String lastName, String email, String personalCode, String registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDate = registrationDate;
    }

    public String toString() {
        return firstName + "," + lastName + "," + email + "," + personalCode + "," + registrationDate;
    }

    public String editName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    public String editLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }

    public String editEmail(String email) {
        this.email = email;
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public String[] toRow() {
        return new String[] {
                firstName, lastName, email, personalCode, registrationDate
        };
    }

    public static StudentTemplate readCSV(String line) {
        String[] parts = line.split(",");
        StudentTemplate student = new StudentTemplate(parts[0], parts[1], parts[2], parts[3], parts[4]);
        return student;
    }
}