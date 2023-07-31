package py.com.daas.adamspayintegration.services;
import py.com.daas.adamspayintegration.entities.ProductInOrder;
import py.com.daas.adamspayintegration.entities.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
