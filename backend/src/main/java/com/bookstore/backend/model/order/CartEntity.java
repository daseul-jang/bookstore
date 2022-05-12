package com.bookstore.backend.model.order;

import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.model.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_CODE")
    private String cartCode;

    @OneToOne
    @JoinColumn(name = "USER_CODE")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "BOOK_CODE")
    private BookEntity bookEntity;

    @Column(name = "CART_TOTALPRICE")
    private String cartTotalPrice;

}
