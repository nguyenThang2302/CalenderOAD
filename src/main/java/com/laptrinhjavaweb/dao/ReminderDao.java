package com.laptrinhjavaweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Appointment;
import com.laptrinhjavaweb.entity.MapperAppointment;
import com.laptrinhjavaweb.entity.Reminder;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Repository
public class ReminderDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	@Autowired
	HomeServiceImpl homeService;
	
	public Reminder findReminderByAppointmentId(int appointment_id) {
		List<Reminder> list = new ArrayList<Reminder>();
		String sql = "select * from reminders where appointment_id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{appointment_id},new
				 BeanPropertyRowMapper<Reminder>(Reminder.class));
	}
	
	public int createOneReminder(Reminder r, int appointment_id) {
		String sql = "insert into reminders (appointment_id, detail) values (?, ?)";
		return _jdbcTemplate.update(sql, appointment_id, r.getDetail());
	}
	
	public int updateOneReminder(Reminder r) {
		String sql = "update reminders set detail = ? where appointment_id = ?";
		return _jdbcTemplate.update(sql, r.getDetail(), r.getAppointment_id());
	}
}
