public class Friend {
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;

    public Friend(String firstName, String lastName, String email, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
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
    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
