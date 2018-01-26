package com.projekt.ai.dal.domain.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Repository
public interface CartRepository extends JpaRepository<CartPosition, CartPositionId> {
    CartPosition findByCartPositionId(CartPositionId cartPositionId);

    @Query("select c  from CartPosition c where c.cartPositionId.userId = :userId")
    List<CartPosition> getCartPositionsByUserId(@Param("userId") Long userId);
}
