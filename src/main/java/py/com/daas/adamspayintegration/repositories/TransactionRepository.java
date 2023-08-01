package py.com.daas.adamspayintegration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.daas.adamspayintegration.entities.OrderMain;
import py.com.daas.adamspayintegration.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByOrder(OrderMain order);
}
