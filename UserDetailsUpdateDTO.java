package gr.aueb.cf.ch18.homework;

public class UserDetailsUpdateDTO extends BaseDTO {
    private String firstname;

    // Constructor
    public UserDetailsUpdateDTO(Long id, String firstname) {
        setId(id); // Use the inherited method to set the ID
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
