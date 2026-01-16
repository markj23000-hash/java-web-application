package com.d288.mark.services;


import com.d288.mark.Enumeration.StatusType;
import com.d288.mark.dao.CartRepository;
import com.d288.mark.dao.CountryRepository;
import com.d288.mark.dao.CustomerRepository;
import com.d288.mark.dao.DivisionRepository;
import com.d288.mark.entities.Cart;
import com.d288.mark.entities.CartItem;
import com.d288.mark.entities.Customer;
import com.d288.mark.exception.CartItemNotFoundException;
import com.d288.mark.exception.CartNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    /*
    private final CustomerRepository customerRepository;
    private final CountryRepository countryRepository;
    private final DivisionRepository divisionRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               CountryRepository countryRepository,
                               DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.countryRepository = countryRepository;
        this.divisionRepository = divisionRepository;
    } */
    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

                               @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve the cart info from services
        Cart cart = purchase.getCart();
        cart.setStatus(StatusType.ordered); //todo is this correct?

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        //populate customer with cart
       // Cart cart = purchase.getCart();// was customer
       // cart.add(cart);

        //todo does this go in checkoutService.java placeOrder? Task G
          if (cart == null) {
            throw new CartNotFoundException("Cart must not be null");
        } else if (cart.getCartItems() == null || cart.getCartItems().isEmpty()) {
            throw new CartItemNotFoundException("Cart must not be empty");
          }
          else {
        //save to the database
        cartRepository.save(cart);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);

           }
    }

        private String generateOrderTrackingNumber () {

            return UUID.randomUUID().toString();
        }
    }