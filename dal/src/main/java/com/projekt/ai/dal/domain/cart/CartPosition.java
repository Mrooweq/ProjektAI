package com.projekt.ai.dal.domain.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 2017-11-06.
 */

@Entity
@Table(name="CART")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartPosition implements Serializable {

    @Embedded
    @Id
    private CartPositionId cartPositionId;

    @Column(name = "QUANTITY")
    private int quantity;
}
