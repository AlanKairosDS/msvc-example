package com.spring.msvc.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MsvcTestApplication {

  public static void main (String[] args) {
    SpringApplication application = new SpringApplication(MsvcTestApplication.class);
    application.run(args);
  }
}
