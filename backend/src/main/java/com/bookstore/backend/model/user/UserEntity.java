package com.bookstore.backend.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/*@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "user_id")})
@DynamicInsert
@DynamicUpdate*/
public class UserEntity {
    /*@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "user_code")
    private String userCode;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_pass", nullable = false)
    private String userPass;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_email")
    private String userEmail;

    @CreatedDate
    @Column(name = "user_regDate", nullable = false)
    private LocalDateTime userRegDate;

    @Column(name = "user_delete", nullable = false, columnDefinition = "char(1) default 'N'")
    private String userDelete;*/
}
