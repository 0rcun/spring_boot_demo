package com.hkarabakla.spring_boot_demo.book;

import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookDto create(@Valid @RequestBody BookDto bookDto) {
        return bookService.create(bookDto.toBook()).toBookDto();
    }

    @GetMapping(params = {"page", "size"})
    public List<BookDto> list(@RequestParam("page") int page, @RequestParam("size") int size) {
        return bookService.list(PageRequest.of(page, size)).stream()
                .map(Book::toBookDto)
                .collect(Collectors.toList());
    }

    @GetMapping(params = {"author", "page", "size"})
    public List<BookDto> listByAuthor(@RequestParam("author") String author, @Min(value = 0) @RequestParam("page") int page, @RequestParam("size") int size) {
        return bookService.list(author, PageRequest.of(page, size)).stream()
                .map(Book::toBookDto)
                .collect(Collectors.toList());
    }
}
