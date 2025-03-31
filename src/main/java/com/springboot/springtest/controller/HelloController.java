package com.springboot.springtest.controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping(value = "req-param")
    public String reqParam(@RequestParam Map<String,String> param) {

        StringBuilder container = new StringBuilder();

            param.forEach((key, value ) -> {
                container.append(key).append(" = ").append(value).append("\n");

            });

            return container.toString();
    }
}
