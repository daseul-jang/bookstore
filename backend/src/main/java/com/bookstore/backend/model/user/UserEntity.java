package com.bookstore.backend.model.user;

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
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String userCode;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPass;

    @Column(nullable = true)
    private String userPhone;

    @Column(nullable = true)
    private String userEmail;
}
