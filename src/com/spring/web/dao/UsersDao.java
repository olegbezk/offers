package com.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("usersDao")
public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean create(User user) {

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("name", user.getName());
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());

		return jdbc.update(
				"insert into users (username, password, name, email, enabled, authority) values (:username, :password, :name, :email, :enabled, :authority)",
				params) == 1;
	}

	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	public List<User> getAllUsers() {
		return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
	}

}
