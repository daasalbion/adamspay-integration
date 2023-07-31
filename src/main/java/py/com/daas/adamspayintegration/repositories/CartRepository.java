package py.com.daas.adamspayintegration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.daas.adamspayintegration.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
