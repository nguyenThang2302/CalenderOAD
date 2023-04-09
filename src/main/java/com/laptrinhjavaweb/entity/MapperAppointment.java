package com.laptrinhjavaweb.entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.ibm.icu.text.SimpleDateFormat;

public class MapperAppointment implements org.springframework.jdbc.core.RowMapper<Appointment> {

	public Appointment mapRow(ResultSet res, int rowNum) throws SQLException {

		Appointment sliders = new Appointment();
		sliders.setId(res.getInt("id"));
		sliders.setName(res.getString("name"));
		sliders.setDate(res.getDate("date"));
		sliders.setLocation(res.getString("location"));
		sliders.setStart_time(res.getString("start_time"));
		sliders.setEnd_time(res.getString("end_time"));
		sliders.setDuration(res.getString("duration"));
		
		return sliders;
	}
}
