package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Cart;
import com.matrimony.soul.sync.unsync.domain.CartStatus;
import com.matrimony.soul.sync.unsync.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getOrdersByOrganizerId(int organizerId){
        return cartRepository.ALLOrderByOrganizerId(organizerId);
    }

    public boolean updateCartStatus(int cartId, CartStatus status){
        int rowAffected = cartRepository.updateStatus(cartId, status);
        return rowAffected>0;
    }
}
