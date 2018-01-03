package com.ciazhar.authservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
public class Account {
    @Id
    private String id;
    // @UserMustExists
    private String userId;
    private String account;
    private AccountSourceType accountSourceType;
    private Date createdAt;
    private String createdBy;
    private Date lastModifiedAt;
    private String lastModifiedBy;
}