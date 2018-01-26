package com.projekt.ai.dal.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(Long id);
    List<Book> findAll();
}
