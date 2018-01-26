package com.projekt.ai.bll.model.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Lenovo on 2017-12-05.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartPositionDto {
    private Long bookId;
    private String title;
    private String author;
    private Double price;
    private Integer quantity;
}