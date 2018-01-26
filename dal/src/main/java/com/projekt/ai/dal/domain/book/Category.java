package com.projekt.ai.dal.domain.book;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 2017-11-06.
 */

@Entity
@Table(name="CATEGORY")
@Data
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;
}
