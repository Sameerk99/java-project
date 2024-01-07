public class CompetitorName {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    // Constructor for CompetitorName
    public CompetitorName(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getter methods for CompetitorName
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // Method to get the full name
    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Method to get initials
    public String getInitials() {
        return String.valueOf(firstName.charAt(0)) + String.valueOf(middleName.charAt(0)) + String.valueOf(lastName.charAt(0));
    }
}


