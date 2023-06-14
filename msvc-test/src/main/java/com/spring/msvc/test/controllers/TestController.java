package com.spring.msvc.test.controllers;

import com.spring.common.tools.entity.RestResponse;
import com.spring.msvc.test.dto.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-endpoint")
public class TestController {

  @PostMapping("/customer")
  public ResponseEntity<RestResponse<Object>> customer (@Valid @RequestBody Customer custom) {
    return new ResponseEntity<>(RestResponse.builder()
            .code(HttpStatus.OK.value())
            .message("Success")
            .error(false)
            .description("Success")
            .build(), HttpStatus.OK);
  }
}
