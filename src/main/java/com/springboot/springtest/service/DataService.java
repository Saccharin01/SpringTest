package com.springboot.springtest.service;

import com.springboot.springtest.dto.PostDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.lang.Object;

@Service
public class DataService {

    private final JdbcTemplate jdbcTemplate;

    public DataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PostDto lookData(int id){
        String sql = "select * from post where id = ?";

        PostDto result = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            PostDto dto = new PostDto();
//            dto.setId(rs.getInt("id"));
            dto.setName(rs.getString("name"));
            dto.setHobby(rs.getString("hobby"));
            return dto;
        });

        return result;

    }

    public void insertData(PostDto postDto) {
        String sql = "INSERT INTO post (name, hobby) VALUES (?, ?)";
        jdbcTemplate.update(sql, postDto.getName(), postDto.getHobby());
    }
}