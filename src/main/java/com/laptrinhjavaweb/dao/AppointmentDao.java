package com.laptrinhjavaweb.dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.Appointment;
import com.laptrinhjavaweb.entity.MapperAppointment;

@Repository
public class AppointmentDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Appointment> findAllAppointment() {
		List<Appointment> list = new ArrayList<Appointment>();
		String sql = "select * from appointments";
		list = _jdbcTemplate.query(sql, new MapperAppointment());
		return list;
	}
	
	public int createOneAppointment(Appointment a) {
		
	    String sqlAppointment = "insert into appointments (name, date, location, start_time, end_time, duration) values (?, ?, ?, ?, ?, ?)";
	    
	    PreparedStatementCreator psc = con -> {
	        PreparedStatement ps = con.prepareStatement(sqlAppointment, new String[] {"id"});
	        ps.setString(1, a.getName());
	        ps.setDate(2, a.getDate());
	        ps.setString(3, a.getLocation());
	        ps.setString(4, a.getStart_time());
	        ps.setString(5, a.getEnd_time());
	        ps.setString(6, a.getDuration());
	        return ps;
	    };
	    
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    
	    int result = _jdbcTemplate.update(psc, keyHolder);

	    if (result > 0) {
	        int appointmentId = keyHolder.getKey().intValue();
	        
	        String sqlReminder = "insert into reminders (appointment_id) values (?)";
	        _jdbcTemplate.update(sqlReminder, appointmentId);
	        
	    }

	    return result;
	}
	
	public boolean checkAppointmentExist(Appointment a) {
	    String sql = "select count(*) from appointments where date = ?";
	    int count = _jdbcTemplate.queryForObject(sql, Integer.class, a.getDate());
	    return count > 0;
	}
	
	public int deleteOneAppointment(int id) {
		String sqlReminder = "delete from reminders where id = ?";
		int result = _jdbcTemplate.update(sqlReminder, id);
		String sql = "delete from appointments where id = ?";
		_jdbcTemplate.update(sql, id);
		return result;
	}
	
	public Appointment findByIdAppointment(int id) {
		List<Appointment> list = new ArrayList<Appointment>();
		String sql = "select * from appointments where id = ?";
		return _jdbcTemplate.queryForObject(sql, new Object[]{id},new
				 BeanPropertyRowMapper<Appointment>(Appointment.class));
	}
	
	public int updateOneAppointment(Appointment a) {
		String sql = "update appointments set name = ?, date = ?, location = ?, start_time = ?, end_time = ?, duration = ? where id = ?";
		return _jdbcTemplate.update(sql, a.getName(), a.getDate(), a.getLocation(), a.getStart_time(), a.getEnd_time(), a.getDuration(), a.getId());
	}
	
}
