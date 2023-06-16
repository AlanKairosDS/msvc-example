package com.spring.msvc.test;

import com.spring.common.tools.config.ControllerExceptionHandler;
import com.spring.msvc.test.controllers.TestController;
import com.spring.msvc.test.dto.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExampleTest {

  @Autowired
  TestController testController;

  @Autowired
  ControllerExceptionHandler controllerExceptionHandler;

  @Test
  void ejecucionExitosaTest () {
    var ejecucion = testController.customer(Customer.builder().name("Alan").location("Prueba").build());
    assertNotNull(ejecucion);
  }

  @Test
  void exceptionTest () {
    var exception = controllerExceptionHandler.myOwnException(new Exception(), null);
    assertNotNull(exception);
  }
}
