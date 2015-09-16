package com.spring.web.test.tests;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.web.dao.UsersDao;

@ContextConfiguration(locations = {
		"classpath:com/spring/web/config/security-context.xml",
		"classpath:com/spring/web/config/dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
//	@Autowired
//	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		JdbcTemplate jddc = new JdbcTemplate(dataSource);
		//jddc.execute("delete from authorities where username = 'Admin'");
	}
	
	@Test
	public void testUserCreation() {
		assertEquals("Dummy test", 1, 1);
	}

}
