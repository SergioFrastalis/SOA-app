package gr.aueb.cf.ch18.homework;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Instantiate the DAO
        UserDetailsDAO userDetailsDAO = new UserDetailsDAOImpl();

        // Instantiate the Service with the DAO
        UserDetailsService userDetailsService = new UserDetailsServiceImpl(userDetailsDAO);

        // Create a new user
        UserDetailsInsertDTO insertDTO = new UserDetailsInsertDTO("John Doe");
        userDetailsService.createUser(insertDTO);

        // Retrieve and print the created user
        Optional<UserDetails> user = userDetailsService.getUser(1L);
        user.ifPresent(u -> System.out.println("User found: " + u.getFirstname()));

        // Update the user
        UserDetailsUpdateDTO updateDTO = new UserDetailsUpdateDTO(1L, "Jane Doe");
        userDetailsService.updateUser(updateDTO);

        // Retrieve and print the updated user
        user = userDetailsService.getUser(1L);
        user.ifPresent(u -> System.out.println("Updated User: " + u.getFirstname()));

        // Delete the user
        userDetailsService.deleteUser(1L);

        // Try to retrieve the user again to confirm deletion
        user = userDetailsService.getUser(1L);
        if (user.isEmpty()) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User still exists: " + user.get().getFirstname());
        }
    }
}
