package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Appointment;
import com.laptrinhjavaweb.entity.Reminder;
import com.laptrinhjavaweb.entity.User;

@Service
public interface IHomeService {
	@Autowired
	public List<Appointment> findAllAppointment();
	@Autowired
	public int createOneAppointment(Appointment a);
	@Autowired
	public int deleteOneAppointment(int id);
	@Autowired
	public Appointment findByIdAppointment(int id);
	@Autowired
	public int updateOneAppointment(Appointment a);
	@Autowired
	public Reminder findReminderByAppointmentId(int appointment_id);
	@Autowired
	public int createOneReminder(Reminder r, int appointment_id);
	@Autowired
	public int updateOneReminder(Reminder r);
	@Autowired
	public int createOneUser(User u, int appointment_id);
	@Autowired
	public List<User> findAllUserByAppointmentId(int appointment_id);
	@Autowired
	public int countUsersByAppointmentId(int appointment_id);
	@Autowired
	public boolean checkAppointmentExist(Appointment a);
}
