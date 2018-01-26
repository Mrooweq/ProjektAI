package com.projekt.ai.bll.service.cart;

import com.projekt.ai.bll.model.invoice.InvoiceDto;
import com.projekt.ai.bll.service.MainAssembler;
import com.projekt.ai.dal.domain.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class InvoiceAssembler extends MainAssembler<Invoice, InvoiceDto> {

    @Autowired
    private InvoicePositionAssembler invoicePositionAssembler;

    @Override
    public InvoiceDto toDto(Invoice invoice) {
        return InvoiceDto.builder()
                .invoiceDate(invoice.getInvoiceDate())
                .invoiceValue(invoice.getInvoiceValue())
                .invoicePositionDtoList(invoicePositionAssembler.toDtoList(invoice.getInvoicePositionList()))
                .build();
    }
}
