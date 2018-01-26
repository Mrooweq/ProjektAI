package com.projekt.ai.dal.domain.user;

import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 2017-12-03.
 */

@Entity
@Table(name="ADDRESS")
@Setter
public class Address implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "POST_NUMBER")
    private String postNumber;
}
