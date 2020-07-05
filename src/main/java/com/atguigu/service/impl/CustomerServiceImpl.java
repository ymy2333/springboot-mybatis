package com.atguigu.service.impl;



import com.atguigu.dao.CustomerDao;
import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Resource
    CustomerDao customerDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;//操作String类型

    @Override
    public List<Customer> findCustomers() {
        String key = "allcustomer";
        // 先查询redis中是否有数据，如果有直接返回redis的数据
        List<Customer> list = (List<Customer>)redisTemplate.boundValueOps(key).get();
        if (list != null) {
            System.out.println(" from redis list = " + list);
            return list;
        }
        // 如果没有，查询数据库
        list = customerDao.findAll();
        redisTemplate.boundValueOps(key).set(list);
        System.out.println("from mysql list=" + list);
        return list;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.getOne(id);
    }

    @Override
    public void saveCustomer(Customer c) {
        customerDao.save(c);
    }

    @Override
    public void updateCustomer(Customer c) {
        customerDao.save(c);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteById(id);
    }
}
