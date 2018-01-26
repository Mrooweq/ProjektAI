package com.projekt.ai.bll.model.cart;

import io.swagger.annotations.ApiModelProperty;
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
public class CartPositionIdDto {
    @ApiModelProperty(required = true)
    private Long userId;

    @ApiModelProperty(required = true)
    private Long bookId;
}