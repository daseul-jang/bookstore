package com.bookstore.backend.model.user;

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
public class AddressEntity {
    @Id
    @OneToOne
    @JoinColumn(name = "USER_CODE")
    private UserEntity userEntity;
    private String zipCode;
    private String address1;
    private String address2;
}
