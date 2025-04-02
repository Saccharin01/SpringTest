package com.springboot.springtest.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.springboot.springtest.dto.PostDto;


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
        return "request appended! : \n"+container;
    }
    @GetMapping(value = "/user")
    public String user(@RequestParam Map<String, Object> params) {
        PostDto container = new PostDto();

        try{
            if(!params.containsKey("name") || !params.containsKey("hobby")) {
                throw new IllegalArgumentException("name and hobby are required");
            }
                container.setName(params.get("name").toString());
                container.setHobby(params.get("hobby").toString());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() , e);
        }
        return """
        당신의 이름은 %s 이고 당신의 취미는 %s 입니다.
    
    """.formatted(container.getName(), container.getHobby());

    }

    @PostMapping(value = "/user")
    public String postUser(@RequestBody PostDto postDto) {
        return postDto.toString();
    }
}
