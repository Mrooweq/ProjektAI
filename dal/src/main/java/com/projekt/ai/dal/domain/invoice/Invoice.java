package com.projekt.ai.dal.domain.invoice;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2017-11-06.
 */

@Entity
@Table(name="INVOICE")
@Data
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INVOICE")
    @SequenceGenerator(name = "SEQ_INVOICE", sequenceName = "SEQ_INVOICE")
    @Column(name = "ID")
    private Long id;

    @Column(name = "INVOICE_DATE")
    private Date invoiceDate;

    @Column(name = "INVOICE_VALUE")
    private Double invoiceValue;

    @Column(name = "USER_ID")
    private Long userId;

    @OneToMany(mappedBy="invoice")
    private List<InvoicePosition> invoicePositionList;
}
