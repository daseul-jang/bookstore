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
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_code")
    private String imgCode;

    @ManyToOne
    @JoinColumn(name = "book_code")
    private BookEntity bookEntity;

    @Column(name = "img_url")
    private String imgUrl;
}
