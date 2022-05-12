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

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "USER_ID")})
@DynamicInsert
@DynamicUpdate
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "USER_CODE")
    private String userCode;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "USER_PASS", nullable = false)
    private String userPass;

    @Column(name = "USER_PHONE")
    private String userPhone;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @CreatedDate
    @Column(name = "USER_REGDATE", nullable = false)
    private LocalDateTime userRegDate;

    @Column(name = "USER_DELETE", nullable = false, columnDefinition = "default 'N'")
    private String userDelete;
}
