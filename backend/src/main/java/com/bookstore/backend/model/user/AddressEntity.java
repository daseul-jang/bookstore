package com.bookstore.backend.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/*@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")*/
public class AddressEntity implements Serializable {
    /*@Id
    @OneToOne
    @JoinColumn(name = "user_code")
    private UserEntity userEntity;

    @Column(name = "zip_code")
    private String zipCode;
    private String address1;
    private String address2;*/
}
