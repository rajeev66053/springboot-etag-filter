package com.java.etagfilter.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RestEndPoint {

    @GetMapping("/rest/{name}")
    String hi(@PathVariable String name, HttpServletRequest request) {
        System.out.println("etag -- " + request.getHeader(HttpHeaders.ETAG));
        System.out.println("if-none-match -- " + request.getHeader(HttpHeaders.IF_NONE_MATCH));
        return "hello " + name;
    }
    @GetMapping("/rest12/{name}")
    String hello(@PathVariable String name) {
        return "hello123" + name;
    }

    @GetMapping("/custom/{name}")
    ResponseEntity<String> customHandler(@PathVariable String name) {

        return ResponseEntity.ok()
                .eTag(name)
                .body("hello " + name);
    }
}