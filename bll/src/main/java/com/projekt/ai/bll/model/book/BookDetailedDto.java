package com.projekt.ai.bll.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Lenovo on 2017-11-08.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailedDto {
    private Long id;
    private String category;
    private String title;
    private String author;
    private long isbn;
    private String publisher;
    private int yearOfPublish;
    private String placeOfPublish;
    private String typeOfCover;
    private String description;
    private int numberOfAvailablePieces;
    private Double price;
}
