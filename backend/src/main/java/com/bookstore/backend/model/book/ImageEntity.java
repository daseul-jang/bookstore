package com.bookstore.backend.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMG_CODE")
    private String imgCode;

    @ManyToOne
    @JoinColumn(name = "BOOK_CODE")
    private BookEntity bookEntity;

    @Column(name = "IMG_URL")
    private String imgUrl;
}
