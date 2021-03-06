package com.bookstore.backend.controller;

import com.bookstore.backend.dto.ResponseDTO;
import com.bookstore.backend.dto.book.BookDTO;
import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> bookRegister(@RequestBody BookDTO dto) {
        log.info("컨트롤러 dto : {}", dto);
        try {
            BookEntity entity = BookDTO.toEntity(dto);
            log.info("컨트롤러 entity : {}", entity);
            return ResponseEntity.ok(bookService.registerBook(entity));
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
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

    @PutMapping("/{bookCode}")
    public ResponseEntity<?> bookUpdate(@PathVariable("bookCode") Long bookCode, @RequestBody BookDTO dto) {
        log.info("update dto : {}", dto);
        dto.setBookCode(bookCode);
        BookEntity entity = BookDTO.toEntity(dto);
        bookService.updateBook(entity);
        return ResponseEntity.ok("");
    }
}
