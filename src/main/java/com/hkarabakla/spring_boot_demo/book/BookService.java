package com.hkarabakla.spring_boot_demo.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book create(Book book) {
        return bookRepo.save(book);
    }

    public Page<Book> list(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    public Page<Book> list(String author, Pageable pageable) {

        return bookRepo.findAllByAuthors_NameContainingIgnoreCase(author, pageable);
    }
}
