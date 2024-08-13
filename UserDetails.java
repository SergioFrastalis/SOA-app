package gr.aueb.cf.ch18.homework;

import java.util.Objects;

public class UserDetails extends AbstractEntity {
    private String firstname;

    public UserDetails() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // Check equality for the superclass if needed

        UserDetails that = (UserDetails) o;

        return Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return 31 * (firstname != null ? firstname.hashCode() : 0);
    }

//    or
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstname);
//    }

}
