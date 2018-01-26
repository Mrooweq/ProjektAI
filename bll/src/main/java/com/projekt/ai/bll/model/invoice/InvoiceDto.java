package com.projekt.ai.bll.model.invoice;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2017-11-08.
 */

@Data
@Builder
public class InvoiceDto {
    private Date invoiceDate;
    private Double invoiceValue;
    private List<InvoicePositionDto> invoicePositionDtoList;
}
