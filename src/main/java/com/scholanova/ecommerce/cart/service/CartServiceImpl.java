package com.scholanova.ecommerce.cart.service;

import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartServiceImpl implements CartService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart addProductToCart(Cart cart, Long productId, int quantity) {
    	try {
    		Product product = productRepository.findById(productId).orElseThrow(() -> new CartException(""));
    		cart.addProduct(product, quantity);
    	}catch(Exception exc){
    		throw new CartException(exc.getMessage())
    	}
    	return cart;
    }

    @Override
    public Cart changeProductQuantity(Cart cart, Long productId, int quantity) throws CartException {
    	try {
    		Product product = productRepository.findById(productId).orElseThrow(() -> new CartException(""));
    		cart.changeProductQuantity(product, quantity);
    	}catch(Exception exc){
    		throw new CartException(exc.getMessage())
    	}
    	return cart;
    }
}