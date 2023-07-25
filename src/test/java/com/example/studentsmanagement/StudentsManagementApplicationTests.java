package com.example.studentsmanagement;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@MapperScan("com.example.studentsmanagement.mapper")
class StudentsManagementApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Test
    void contextLoads() {
    }

    @Test
    void getConnect() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
