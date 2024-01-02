package com.sl.openshiftdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class MiscController {
  WebClient client = WebClient.create("172.30.143.246:8080");

  @GetMapping
  public String sayHello() {
    return "Hello from Spring server";
  }

  @GetMapping("/input")
  public String sayHelloWithInput(@RequestParam String input) {
    return "Hello! how are you doing " + input + "?";
  }

  @GetMapping("/get-data-from-pod")
  public String sayHelloFromPod() {
    String response =
        client.get().retrieve().bodyToMono(String.class).onErrorResume(e -> Mono.empty()).block();
    System.out.println(response);
    return "This is the response from the server: " + response;
  }
}
