package com.springboot.springtest.controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "hello")
public class HelloController {
    @GetMapping
    public String index() {
        return "hello Spring Boot";
    }

    @GetMapping(value = "{variable}")
    public String vreb(@PathVariable String variable) {
        return """
                you requested a path %s
                """.formatted(variable);
    }

    @GetMapping(value = "req-param")
    public String reqParam(@RequestParam Map<String,String> param) {

        StringBuilder container = new StringBuilder();

            param.forEach((key, value ) -> {
                container.append(key).append(" = ").append(value).append("\n");

            });

            return container.toString();
    }
}
