package com.projekt.ai.bll.model.book;

import com.projekt.ai.dal.domain.book.Category;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Lenovo on 2017-11-08.
 */

@Data
@Builder
public class BookGeneralDto {
    private Long id;
    private Category category;
    private String title;
    private String author;
    private int numberOfAvailablePieces;
    private Double price;
}
