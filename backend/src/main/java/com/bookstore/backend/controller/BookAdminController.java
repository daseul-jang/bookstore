package com.bookstore.backend.controller;

import com.bookstore.backend.dto.ResponseDTO;
import com.bookstore.backend.dto.book.BookDTO;
import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("admin/book")
public class BookAdminController {
    private final BookService bookService;

    @Autowired
    public BookAdminController(BookService service) {
        this.bookService = service;
    }

    /*@GetMapping
    public ResponseEntity<?> getTest() {
        log.info("겟테스트");
        return ResponseEntity.ok("겟게게겟");
    }*/

    @PostMapping
    public ResponseEntity<?> registerBook(@RequestBody BookDTO dto) {
        log.info("컨트롤러 dto : {}", dto);
        try {
            BookEntity entity = BookDTO.toEntity(dto);
            log.info("컨트롤러 entity : {}", entity);
            return ResponseEntity.ok(bookService.saveBook(entity));
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
