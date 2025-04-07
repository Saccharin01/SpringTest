package com.springboot.springtest.controller;

import org.springframework.web.bind.annotation.*;
import com.springboot.springtest.dto.PostDto;
import java.util.Map;
import com.springboot.springtest.service.DataService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final DataService dataService;

    public UserController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public String index(){
        return "test : post Method EndPoint mapped";
    }

    @PostMapping
    public String post(@RequestBody PostDto postDto) {


        try{
            if(postDto.getName() == null || postDto.getHobby() == null) {
                throw new IllegalArgumentException("name and hobby are required");
            }


            dataService.insertData(postDto);
            //todo 여기에 서비스 로직 넣어야 함


        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "data inserted";
    }
}
