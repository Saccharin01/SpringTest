package com.springboot.springtest.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    @GetMapping
    public String index() {
        return "endPoint hello is mapped";
    }

    @GetMapping(value = "hello")
    public String hello() {
        return "hello springboot";
    }

    @GetMapping(value = "pathvariable/{variable}")
    public String vreb(@PathVariable String variable) {
        return """
                you requested a path %s
                """.formatted(variable);
    }
}
