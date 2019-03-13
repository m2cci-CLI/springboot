package com.training.springcore.bigcorp.repository;

import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@JdbcTest
@ContextConfiguration(classes = {DaoTestConfig.class})
public class SiteDaoImplTest {

}
