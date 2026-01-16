package com.d288.mark.services;

import com.d288.mark.entities.Cart;
import com.d288.mark.entities.CartItem;
import com.d288.mark.entities.Customer;

import lombok.Data;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
