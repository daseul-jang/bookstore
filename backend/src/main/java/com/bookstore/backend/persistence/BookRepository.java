package com.bookstore.backend.persistence;

import com.bookstore.backend.model.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
