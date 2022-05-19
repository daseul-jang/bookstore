package com.bookstore.backend.service;

import com.bookstore.backend.dto.book.BookDTO;
import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public BookEntity saveBook(BookEntity entity) {
        return repository.save(entity);
    }

    public List<BookEntity> BookList() {
        return repository.findAll();
    }
}
