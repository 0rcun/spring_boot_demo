package com.hkarabakla.spring_boot_demo.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {

    Page<Book> findAll(Pageable pageable);

    // Filter books by author name
    Page<Book> findAllByAuthors_NameContainingIgnoreCase(String name, Pageable pageable);
}
