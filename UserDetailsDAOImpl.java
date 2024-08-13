package gr.aueb.cf.ch18.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDetailsDAOImpl implements UserDetailsDAO {
    private final Map<Long, UserDetails> storage = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public void create(UserDetails userDetails) {
        userDetails.setId(idCounter++);
        storage.put(userDetails.getId(), userDetails);
    }

    @Override
    public Optional<UserDetails> read(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Optional<UserDetails> readByName(String firstname) {
        return storage.values().stream()
                .filter(user -> user.getFirstname().equals(firstname))
                .findFirst();
    }

    @Override
    public void update(UserDetails userDetails) {
        if (!storage.containsKey(userDetails.getId())) {
            throw new NameNotFoundException("User not found.");
        }
        storage.put(userDetails.getId(), userDetails);
    }

    @Override
    public void delete(Long id) {
        if (storage.remove(id) == null) {
            throw new NameNotFoundException("User not found.");
        }
    }
}
