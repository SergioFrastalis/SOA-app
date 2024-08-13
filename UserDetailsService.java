package gr.aueb.cf.ch18.homework;

import java.util.Optional;

public interface UserDetailsService {
    void createUser(UserDetailsInsertDTO dto);
    Optional<UserDetails> getUser(Long id);
    void updateUser(UserDetailsUpdateDTO dto);
    void deleteUser(Long id);
}
