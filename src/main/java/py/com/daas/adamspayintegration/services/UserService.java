package py.com.daas.adamspayintegration.services;

import java.util.Collection;

import py.com.daas.adamspayintegration.entities.User;

public interface UserService {
    User findOne(String email);

    Collection<User> findByRole(String role);

    User save(User user);

    User update(User user);
}
