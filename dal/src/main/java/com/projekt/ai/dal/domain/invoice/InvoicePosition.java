package com.projekt.ai.dal.domain.invoice;

import com.projekt.ai.dal.domain.book.Book;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 2017-11-06.
 */

@Entity
@Table(name="INVOICE_POSITION")
@Data
public class InvoicePosition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INVOICE")
    @SequenceGenerator(name = "SEQ_INVOICE", sequenceName = "SEQ_INVOICE")
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE_OF_POSITION")
    private Double priceOfPosition;

    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;
}
