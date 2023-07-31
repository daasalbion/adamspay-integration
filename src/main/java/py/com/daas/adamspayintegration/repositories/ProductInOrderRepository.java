package py.com.daas.adamspayintegration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.daas.adamspayintegration.entities.ProductInOrder;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
