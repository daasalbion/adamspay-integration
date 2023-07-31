package py.com.daas.adamspayintegration.repositories;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.daas.adamspayintegration.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    Collection<User> findAllByRole(String role);

}
