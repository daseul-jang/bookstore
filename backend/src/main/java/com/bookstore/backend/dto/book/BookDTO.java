package com.bookstore.backend.dto.book;

import com.bookstore.backend.model.book.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long bookCode;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String bookGenre;
    private String bookSummary;
    private String bookPublishDate;
    private int bookPrice;
    private String bookDescription;
    private int bookStock;
    private boolean bookStatus;

    public BookDTO(final BookEntity entity) {
        this.bookCode = entity.getBookCode();
        this.bookTitle = entity.getBookTitle();
        this.bookAuthor = entity.getBookAuthor();
        this.bookPublisher = entity.getBookPublisher();
        this.bookGenre = entity.getBookGenre();
        this.bookSummary = entity.getBookSummary();
        this.bookPublishDate = entity.getBookPublishDate();
        this.bookPrice = entity.getBookPrice();
        this.bookDescription = entity.getBookDescription();
        this.bookStock = entity.getBookStock();
        this.bookStatus = entity.isBookState();
    }

    public static BookEntity toEntity(final BookDTO dto) {
        return BookEntity.builder()
                .bookCode(dto.getBookCode())
                .bookTitle(dto.getBookTitle())
                .bookAuthor(dto.getBookAuthor())
                .bookPublisher(dto.getBookPublisher())
                .bookGenre(dto.getBookGenre())
                .bookSummary(dto.getBookSummary())
                .bookPublishDate(dto.getBookPublishDate())
                .bookPrice(dto.getBookPrice())
                .bookDescription(dto.getBookDescription())
                .bookStock(dto.getBookStock())
                .bookState(dto.isBookStatus())
                .build();
    }
}
