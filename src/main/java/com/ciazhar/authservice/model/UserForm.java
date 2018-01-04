package com.ciazhar.authservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserForm {
  @NotBlank @Size(min= 4, max=50)
  private String username;

  @NotBlank @Size(min= 4, max=16)
  private String password;

  @NotBlank
  private String name;

  @NotBlank
  private String role;

  private String description;

}