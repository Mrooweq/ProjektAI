package com.projekt.ai.dal.domain.book;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 2017-11-06.
 */

@Entity
@Table(name="STOCK")
@Data
public class Stock implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER_OF_PIECES")
    private Integer numberOfPieces;
}
