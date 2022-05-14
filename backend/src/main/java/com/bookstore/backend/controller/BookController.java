package com.bookstore.backend.controller;

import com.bookstore.backend.dto.ResponseDTO;
import com.bookstore.backend.dto.book.BookDTO;
import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("books")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public ResponseEntity<?> testBook() {
        BookEntity entity = service.testService();
        log.info("entity " + entity);
        BookDTO dto = BookDTO.builder()
                .bookTitle(entity.getBookTitle())
                .bookAuthor(entity.getBookAuthor())
                .bookPrice(entity.getBookPrice())
                .bookStock(entity.getBookStock())
                .build();
        return ResponseEntity.ok(dto);
    }
}
