package com.bookstore.backend.controller;

import com.bookstore.backend.dto.ResponseDTO;
import com.bookstore.backend.dto.book.BookDTO;
import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping("/test")
    public ResponseEntity<?> testBook() {
        BookEntity entity = bookService.testService();
        log.info("entity " + entity);
        BookDTO dto = BookDTO.builder()
                .bookTitle(entity.getBookTitle())
                .bookAuthor(entity.getBookAuthor())
                .bookPrice(entity.getBookPrice())
                .bookStock(entity.getBookStock())
                .build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<?> bookList() {
        List<BookEntity> entities = bookService.BookList();
        List<BookDTO> dtos = entities.stream().map(BookDTO::new).collect(Collectors.toList());
        ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder().data(dtos).build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{bookCode}")
    public ResponseEntity<?> bookDetail(@PathVariable("bookCode") Long bookCode, BookDTO dto) {
        dto.setBookCode(bookCode);
        BookEntity entity = BookDTO.toEntity(dto);
        return ResponseEntity.ok(bookService.detailBook(entity));
    }
}
