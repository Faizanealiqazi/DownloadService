package com.example.downloadservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID", length = 100)
    private String userId;

    @Column(name = "ACCOUNT_NAME", length = 255)
    private String accountName;

    @Column(name = "BALANCE")
    private double balance;

    @Column(name = "CURRENCY", length = 10)
    private String currency;

    @Column(name = "STATUS", length = 50)
    private String status;

    @Column(name = "CREATED_AT")
    private String createdAt;

    @Column(name = "UPDATED_AT")
    private String updatedAt;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "PHONE", length = 15)
    private String phone;

}
