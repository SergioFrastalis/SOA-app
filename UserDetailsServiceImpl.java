package gr.aueb.cf.ch18.homework;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsDAO userDetailsDAO;

    public UserDetailsServiceImpl(UserDetailsDAO userDetailsDAO) {
        this.userDetailsDAO = userDetailsDAO;
    }

    @Override
    public void createUser(UserDetailsInsertDTO dto) {
        // Check for duplicate names or other business logic
        Optional<UserDetails> existingUser = userDetailsDAO.readByName(dto.getFirstname());
        if (existingUser.isPresent()) {
            throw new UserIdAlreadyExistsException("User with this name already exists.");
        }
        UserDetails user = new UserDetails();
        user.setFirstname(dto.getFirstname());
        userDetailsDAO.create(user);
    }

    @Override
    public Optional<UserDetails> getUser(Long id) {
        return userDetailsDAO.read(id);
    }

    @Override
    public void updateUser(UserDetailsUpdateDTO dto) {
        Optional<UserDetails> existingUser = userDetailsDAO.read(dto.getId());
        if (existingUser.isEmpty()) {
            throw new NameNotFoundException("User not found.");
        }
        UserDetails user = existingUser.get();
        user.setFirstname(dto.getFirstname());
        userDetailsDAO.update(user);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<UserDetails> existingUser = userDetailsDAO.read(id);
        if (existingUser.isEmpty()) {
            throw new NameNotFoundException("User not found.");
        }
        userDetailsDAO.delete(id);
    }
}
