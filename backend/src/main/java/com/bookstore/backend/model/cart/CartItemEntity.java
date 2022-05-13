package com.bookstore.backend.model.cart;

import com.bookstore.backend.model.book.BookEntity;
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
@Table(name = "cart_item")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_code")
    private String cartItemCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cart_code")
    private CartEntity cartEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="book_code")
    private BookEntity bookEntity;

    @Column(name = "item_count")
    private int cartItemCnt;

    public static CartItemEntity createCartItem(CartEntity cart, BookEntity book, int count) {
        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setCartEntity(cart);
        cartItem.setBookEntity(book);
        cartItem.setCartItemCnt(count);
        return cartItem;
    }

    public void addCount(int count) {
        this.cartItemCnt += count;
    }

    public void updateCount(int count) {
        this.cartItemCnt = count;
    }
}
