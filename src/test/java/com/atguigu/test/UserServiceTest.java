package com.atguigu.test;


import com.atguigu.domain.User;
import com.atguigu.service.UserSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserSerivce userSerivce;

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection conn = dataSource.getConnection();
        System.out.println("conn = " + conn);
        conn.close();
    }

    @Test
    public void testFindAll() {
        List<User> list = userSerivce.finaAll();
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }
}
