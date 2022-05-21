package com.bookstore.backend.model.cart;

import com.bookstore.backend.model.book.BookEntity;
import com.bookstore.backend.model.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")*/
public class CartEntity {
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_code")
    private String cartCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    private UserEntity userEntity;

    @OneToMany
    private List<CartItemEntity> cartItems = new ArrayList<>();

    public static CartEntity createCart(UserEntity user) {
        CartEntity cart = new CartEntity();
        cart.setUserEntity(user);
        return cart;
    }*/

}
