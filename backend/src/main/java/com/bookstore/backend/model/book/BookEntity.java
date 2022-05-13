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
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_code")
    private String bookCode;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "book_genre", nullable = false)
    private String bookGenre;

    @Column(name = "book_summary", nullable = false)
    private String bookSummary;

    @Column(name = "book_publishDate", nullable = false)
    private String bookPublishDate;

    @Column(name = "book_price", nullable = false)
    private String bookPrice;

    @Column(name = "book_description", nullable = false)
    private String bookDescription;

    @Column(name = "book_stock", nullable = false)
    private String bookStock;

    @CreatedDate
    @Column(name = "book_regDate", nullable = false)
    private LocalDateTime bookRegDate;

    @LastModifiedDate
    @Column(name = "book_modifyDate", nullable = false)
    private LocalDateTime bookModifyDate;

}
