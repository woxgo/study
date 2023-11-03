package com.py;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SshMysqlApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    void contextLoads() {
        String sql = "select * from dbp_platform";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> map : maps){
            System.out.println(map);
        }
    }
}
