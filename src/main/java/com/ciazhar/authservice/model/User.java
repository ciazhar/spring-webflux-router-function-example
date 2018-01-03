package com.ciazhar.authservice.model;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    
    @Builder.Default @JsonIgnore
    private boolean isAccountNonExpiredAlias = true;
    
    @Builder.Default @JsonIgnore
    private boolean isAccountNonLockedAlias = true;
    
    @Builder.Default @JsonIgnore
    private boolean isCredentialsNonExpiredAlias = true;
    
    @Builder.Default @JsonIgnore
    private boolean isEnabledAlias = true;

    private String description;
    private Date lastLoginAt;
    private String ip;

    @Builder.Default 
    private Date createdAt = new Date();

    private String createdBy;

    @Builder.Default
    private Date lastModifiedAt = new Date();

    private String lastModifiedBy;

    private String role;

    @JsonIgnore
    private Set<Account> accounts;

    @JsonIgnore
    private Set<String> authoritySet;

}