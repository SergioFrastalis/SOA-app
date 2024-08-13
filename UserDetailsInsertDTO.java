package gr.aueb.cf.ch18.homework;

public class UserDetailsInsertDTO extends BaseDTO {
    private String firstname;

    // Constructor
    public UserDetailsInsertDTO(String firstname) {
        this.firstname = firstname;
    }

    // Getter and Setter
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
