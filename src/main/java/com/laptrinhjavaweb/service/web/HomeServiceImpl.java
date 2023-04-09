package com.laptrinhjavaweb.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.AppointmentDao;
import com.laptrinhjavaweb.dao.ReminderDao;
import com.laptrinhjavaweb.dao.UserDao;
import com.laptrinhjavaweb.entity.Appointment;
import com.laptrinhjavaweb.entity.Reminder;
import com.laptrinhjavaweb.entity.User;


@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private ReminderDao reminderDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Appointment> findAllAppointment() {
		return appointmentDao.findAllAppointment();
	}
	
	@Override
	public int createOneAppointment(Appointment a) {
		return appointmentDao.createOneAppointment(a);
	}
	
	@Override
	public int deleteOneAppointment(int id) {
		return appointmentDao.deleteOneAppointment(id);
	}
	
	@Override
	public Appointment findByIdAppointment(int id) {
		return appointmentDao.findByIdAppointment(id);
	}
	
	@Override
	public int updateOneAppointment(Appointment a) {
		return appointmentDao.updateOneAppointment(a);
	}
	
	@Override
	public Reminder findReminderByAppointmentId(int appointment_id) {
		return reminderDao.findReminderByAppointmentId(appointment_id);
	}
	
	@Override
	public int createOneReminder(Reminder r, int appointment_id) {
		return reminderDao.createOneReminder(r, appointment_id);
	}
	
	@Override
	public int updateOneReminder(Reminder r) {
		return reminderDao.updateOneReminder(r);
	}
	
	@Override
	public int createOneUser(User u, int appointment_id) {
		return userDao.createOneUser(u, appointment_id);
	}
	
	@Override
	public List<User> findAllUserByAppointmentId(int appointment_id) {
		return userDao.findAllUserByAppointmentId(appointment_id);
	}
	
	@Override
	public int countUsersByAppointmentId(int appointment_id) {
		return userDao.countUsersByAppointmentId(appointment_id);
	}
	
	@Override
	public boolean checkAppointmentExist(Appointment a) {
		return appointmentDao.checkAppointmentExist(a);
	}
}
