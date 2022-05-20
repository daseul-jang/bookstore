package com.bookstore.backend.service;

import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.persistence.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookService {
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookEntity testService() {
        BookEntity entity = BookEntity.builder().bookTitle("제목").bookAuthor("저자").bookPrice(20000).bookStock(100).build();
        repository.save(entity);
        BookEntity savedEntitiy = repository.findById(entity.getBookCode()).get();
        return savedEntitiy;
    }

    public BookEntity registerBook(BookEntity entity) {
        return repository.save(entity);
    }

    public List<BookEntity> BookList() {
        return repository.findAll();
    }

    public Optional<BookEntity> detailBook(BookEntity entity) {
        return repository.findById(entity.getBookCode());
    }

    public void updateBook(BookEntity entity) {
        Optional<BookEntity> beforeEntity = detailBook(entity);
        beforeEntity.ifPresent(book -> {
            log.info("optional.isPresent book? : {}", book);
        });
    }
}
