package com.sl.openshiftdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@Slf4j
public class MiscController {
  WebClient client = WebClient.create("http://172.30.143.246:8080");

  @GetMapping
  public String sayHello() {
    log.info("sayHello() :: started");
    return "Hello from Spring server";
  }

  @GetMapping("/input")
  public String sayHelloWithInput(@RequestParam String input) {
    log.info("sayHelloWithInput() :: started");
    return "Hello! how are you doing " + input + "?";
  }

  @GetMapping("/get-data-from-pod")
  public String sayHelloFromPod() {
    log.info("sayHelloFromPod() :: started");
    String response =
        client.get().retrieve().bodyToMono(String.class).onErrorResume(e -> Mono.empty()).block();
    System.out.println(response);
    return "This is the response from the server: " + response;
  }
}
