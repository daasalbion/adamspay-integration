package py.com.daas.adamspayintegration.services;

import java.util.Collection;

import py.com.daas.adamspayintegration.entities.Cart;
import py.com.daas.adamspayintegration.entities.ProductInOrder;
import py.com.daas.adamspayintegration.entities.User;

public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
