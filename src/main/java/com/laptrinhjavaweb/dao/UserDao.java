package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Appointment;
import com.laptrinhjavaweb.entity.MapperAppointment;
import com.laptrinhjavaweb.entity.MapperUser;
import com.laptrinhjavaweb.entity.User;

@Repository
public class UserDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int createOneUser(User u, int appointment_id) {
		String sql = "insert into users (appointment_id, name) values (?, ?)";
		return _jdbcTemplate.update(sql, appointment_id, u.getName());
	}
	
	public List<User> findAllUserByAppointmentId(int appointment_id) {
	    String sql = "SELECT * FROM users WHERE appointment_id = ?";
	    return _jdbcTemplate.query(sql, new Object[] { appointment_id }, new MapperUser());
	}
	
	public int countUsersByAppointmentId(int appointment_id) {
	    String sql = "SELECT COUNT(*) FROM users WHERE appointment_id = ?";
	    return _jdbcTemplate.queryForObject(sql, new Object[] { appointment_id }, Integer.class);
	}
}
