package com.projekt.ai.bll.service.cart;

import com.projekt.ai.bll.model.cart.CartPositionDto;
import com.projekt.ai.bll.model.cart.CartPositionIdDto;
import com.projekt.ai.bll.service.MainAssembler;
import com.projekt.ai.dal.domain.cart.CartPosition;
import com.projekt.ai.dal.domain.cart.CartPositionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class CartPositionAssembler extends MainAssembler<CartPosition, CartPositionDto> {

    @Override
    public CartPositionDto toDto(CartPosition cartPosition) {
        return CartPositionDto.builder()
                .bookId(cartPosition.getCartPositionId().getBook().getId())
                .title(cartPosition.getCartPositionId().getBook().getTitle())
                .author(cartPosition.getCartPositionId().getBook().getAuthor())
                .price(cartPosition.getCartPositionId().getBook().getPrice())
                .quantity(cartPosition.getQuantity())
                .build();
    }
}
