package com.laptrinhjavaweb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUser implements org.springframework.jdbc.core.RowMapper<User> {

	public User mapRow(ResultSet res, int rowNum) throws SQLException {

		User sliders = new User();
		sliders.setId(res.getInt("id"));
		sliders.setName(res.getString("name"));
		
		return sliders;
	}
}
