package com.projekt.ai.api.controller;

import com.projekt.ai.api.auth.Secured;
import com.projekt.ai.bll.model.cart.CartPositionDto;
import com.projekt.ai.bll.model.cart.CartPositionIdDto;
import com.projekt.ai.bll.model.invoice.InvoiceDto;
import com.projekt.ai.bll.service.cart.CartService;
import com.projekt.ai.dal.domain.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Secured(Role.USER)
    @RequestMapping(value = "/updateCart", method = RequestMethod.GET)
    public void updateCart(@ModelAttribute CartPositionIdDto cartId, @RequestParam Integer quantity) {
        cartService.updateCart(cartId, quantity);
    }

    @Secured(Role.USER)
    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public List<CartPositionDto> getCart(@RequestParam Long userId) {
        return cartService.getCart(userId);
    }

    @Secured(Role.USER)
    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public InvoiceDto buy(@RequestParam Long userId) {
        return cartService.buy(userId);
    }
}
