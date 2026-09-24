package com.matrimony.soul.sync.unsync.api;

import com.matrimony.soul.sync.unsync.domain.Cart;
import com.matrimony.soul.sync.unsync.domain.CartStatus;
import com.matrimony.soul.sync.unsync.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/organizer/orders")
public class CartApi {

    private final CartService cartService;

    public CartApi(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{organizerId}")
    public ResponseEntity<List<Cart>> getOrganizerOrders(@PathVariable int organizerId){
        List<Cart> orders = cartService.getOrdersByOrganizerId(organizerId);
        return ResponseEntity.ok(orders);
    }

    @PatchMapping("/{cartId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int cartId, @RequestBody Map<String, String> requestBody){
        try{
            CartStatus status = CartStatus.valueOf(requestBody.get("status").toUpperCase());
            boolean updated = cartService.updateCartStatus(cartId,status);

            if(updated){
                return ResponseEntity.ok("Order status updated Successfully.");
            }
            else{
                return ResponseEntity.badRequest().body("Order not found or status update failed");
            }

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Invalid status value provided.");
        }

    }

}
