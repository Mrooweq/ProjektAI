package com.projekt.ai.dal.domain.invoice;

import com.projekt.ai.dal.domain.cart.CartPosition;
import com.projekt.ai.dal.domain.cart.CartPositionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
