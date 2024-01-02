package com.sl.openshiftdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MiscController {

  @GetMapping
  public String sayHello() {
    return "Hello from Spring server";
  }

  @GetMapping("{input}")
  public String sayHelloWithInput(@PathVariable String input) {
    return "Hello! how are you doing " + input + "?";
  }
}
