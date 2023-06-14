package com.spring.msvc.test.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Customer {

  @NotNull
  private String name;

  @NotNull(message = "Location should not be null")
  private String location;
}
