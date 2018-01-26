package com.projekt.ai.bll.service.cart;

import com.projekt.ai.bll.model.invoice.InvoicePositionDto;
import com.projekt.ai.bll.service.MainAssembler;
import com.projekt.ai.dal.domain.invoice.InvoicePosition;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class InvoicePositionAssembler extends MainAssembler<InvoicePosition, InvoicePositionDto> {

    @Override
    public InvoicePositionDto toDto(InvoicePosition invoicePosition) {
        return InvoicePositionDto.builder()
                .priceOfPosition(invoicePosition.getPriceOfPosition())
                .quantity(invoicePosition.getQuantity())
                .title(invoicePosition.getBook().getTitle())
                .author(invoicePosition.getBook().getAuthor())
                .build();
    }
}
