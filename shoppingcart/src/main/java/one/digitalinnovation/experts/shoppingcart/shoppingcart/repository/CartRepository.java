package one.digitalinnovation.experts.shoppingcart.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import one.digitalinnovation.experts.shoppingcart.shoppingcart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>{

}
