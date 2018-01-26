package com.projekt.ai.dal.domain.cart;

import com.projekt.ai.dal.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 2017-12-05.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class CartPositionId implements Serializable {
    private Long userId;

    @ManyToOne
    @JoinColumn
    private Book book;
}
