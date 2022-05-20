package com.bookstore.backend.model.book;

import com.bookstore.backend.model.cart.CartItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_code")
    private Long bookCode;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "book_author", nullable = false)
    private String bookAuthor;

    @Column(name = "book_publisher", nullable = true)
    private String bookPublisher;

    @Column(name = "book_genre", nullable = true)
    private String bookGenre;

    @Column(name = "book_summary", nullable = true)
    private String bookSummary;

    @Column(name = "book_publishDate", nullable = true)
    private String bookPublishDate;

    @Column(name = "book_price", nullable = false)
    private int bookPrice;

    @Column(name = "book_description", nullable = true)
    private String bookDescription;

    //private int bookCount;

    @Column(name = "book_stock", nullable = false)
    private int bookStock;

    @Column(name = "book_state")
    private boolean bookState;

    @CreatedDate
    @Column(name = "book_regDate", nullable = false)
    private LocalDateTime bookRegDate;

    @LastModifiedDate
    @Column(name = "book_modifyDate", nullable = false)
    private LocalDateTime bookModifyDate;

    @OneToMany
    private List<CartItemEntity> cartItems = new ArrayList<>();

    public void update(BookEntity entity) {
        this.bookTitle = entity.getBookTitle();
        this.bookAuthor = entity.getBookAuthor();
        this.bookPublisher = entity.getBookPublisher();
        this.bookGenre = entity.getBookGenre();
        this.bookSummary = entity.getBookSummary();
        this.bookPrice = entity.getBookPrice();
        this.bookPublishDate = entity.getBookPublishDate();
        this.bookDescription = entity.getBookDescription();
        this.bookStock = entity.getBookStock();
        this.bookState = entity.isBookState();
    }
}
