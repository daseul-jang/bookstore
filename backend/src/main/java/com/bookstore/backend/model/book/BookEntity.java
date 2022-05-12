package com.bookstore.backend.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@EntityListeners(AuditingEntityListener.class)
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_CODE")
    private String bookCode;

    @Column(name = "BOOK_TITLE", nullable = false)
    private String bookTitle;

    @Column(name = "BOOK_GENRE", nullable = false)
    private String bookGenre;

    @Column(name = "BOOK_SUMMARY", nullable = false)
    private String bookSummary;

    @Column(name = "BOOK_PUBLISHDATE", nullable = false)
    private String bookPublishDate;

    @Column(name = "BOOK_PRICE", nullable = false)
    private String bookPrice;

    @Column(name = "BOOK_DESCRIPTION", nullable = false)
    private String bookDescription;

    @Column(name = "BOOK_STOCK", nullable = false)
    private String bookStock;

    @CreatedDate
    @Column(name = "BOOK_REGDATE", nullable = false)
    private LocalDateTime bookRegDate;

    @LastModifiedDate
    @Column(name = "BOOK_MODIFYDATE", nullable = false)
    private LocalDateTime bookModifyDate;

}
