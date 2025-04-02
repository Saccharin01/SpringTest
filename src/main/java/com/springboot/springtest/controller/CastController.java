package com.springboot.springtest.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/cast")
public class CastController {

    @GetMapping()
    public String index() {
        return "this is cast End Point";
    }

    @PostMapping(value = "/post-req")
    public String postRequest(@RequestBody Map<String, Object> payload) {
        StringBuilder container = new StringBuilder();

        payload.forEach((key, value) -> {
            container
                    .append(key)
                    .append("=")
                    .append(value)
                    .append("\n");

        });
        return "request appended! : \n"+container.toString();
    }


}
