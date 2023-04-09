package com.laptrinhjavaweb.entity;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperReminder implements org.springframework.jdbc.core.RowMapper<Reminder> {

	public Reminder mapRow(ResultSet res, int rowNum) throws SQLException {

		Reminder sliders = new Reminder();
		sliders.setId(res.getInt("id"));
		sliders.setAppointment_id(res.getInt("appointment_id"));
		sliders.setDetail(res.getString("detail"));
		
		return sliders;
	}
}
