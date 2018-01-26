package com.projekt.ai.dal.domain.book;

import com.projekt.ai.dal.domain.enums.TypeOfCoverEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 2017-11-06.
 */

@Entity
@Table(name="BOOK")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOOK")
    @SequenceGenerator(name = "SEQ_BOOK", sequenceName = "SEQ_BOOK")
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Category category;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "ISBN")
    private long isbn;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "YEAR_OF_PUBLISH")
    private int yearOfPublish;

    @Column(name = "PLACE_OF_PUBLISH")
    private String placeOfPublish;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_OF_COVER")
    private TypeOfCoverEnum typeOfCover;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne
    @JoinColumn(name = "ID")
    private Stock stock;
}
