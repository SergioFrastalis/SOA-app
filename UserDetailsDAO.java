package gr.aueb.cf.ch18.homework;

import java.util.Optional;

public interface UserDetailsDAO {
    void create(UserDetails userDetails);
    Optional<UserDetails> read(Long id);
    Optional<UserDetails> readByName(String firstname);
    void update(UserDetails userDetails);
    void delete(Long id);
}
