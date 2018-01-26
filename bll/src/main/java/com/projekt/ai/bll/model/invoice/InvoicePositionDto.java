package com.projekt.ai.bll.model.invoice;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 * Created by Lenovo on 2017-11-08.
 */

@Data
@Builder
public class InvoicePositionDto {
    private Integer quantity;
    private Double priceOfPosition;
    private String title;
    private String author;
}
