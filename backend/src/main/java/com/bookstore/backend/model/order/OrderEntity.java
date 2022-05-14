package com.bookstore.backend.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")*/
public class OrderEntity {
    /*@Id
    @GeneratedValue(generator = "orderNo")
    @GenericGenerator(name = "orderNo", strategy = "com.bookstore.backend.util.OrderCodeGenerator")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_code")
    private String orderCode;*/
}
