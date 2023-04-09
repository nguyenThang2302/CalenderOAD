package com.laptrinhjavaweb.controller.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.Appointment;
import com.laptrinhjavaweb.entity.Reminder;
import com.laptrinhjavaweb.entity.User;
import com.laptrinhjavaweb.service.web.HomeServiceImpl;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	HomeServiceImpl homeService;
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("appointments", homeService.findAllAppointment());
		return mav;
	}
	
	@RequestMapping(value = "/tao-lich-hen", method = RequestMethod.GET)
	public ModelAndView addAppointment() {
		ModelAndView mav = new ModelAndView("web/createAppointment");
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String checkAppointment(@ModelAttribute("appointments") Appointment appointments) {
	  boolean isValid = homeService.checkAppointmentExist(appointments);
	  if (isValid) {
	    return "web/popupAddAppointment";
	  } else {
		homeService.createOneAppointment(appointments);
	    return "redirect:/trang-chu";  
	  }
	}
	
	@RequestMapping(value = "/xoa-lich-hen/{id}", method = RequestMethod.GET)
	public String appointmentDeleteOne(@PathVariable int id) {
		homeService.deleteOneAppointment(id);
		return "redirect:/trang-chu";
	}
	
	@RequestMapping(value = "/cap-nhat-lich-hen/{id}", method = RequestMethod.GET)
	public String appointmentFindById(@PathVariable int id, Model m) {
		Appointment appointment = homeService.findByIdAppointment(id);
		m.addAttribute("appointment", appointment);
		return "web/updateAppointment";
	}
	
	@RequestMapping(value = "/cap-nhat-lich-hen/save", method = RequestMethod.POST)
	public String appointmentUpdateSave(@ModelAttribute("appointment") Appointment appointment) {
		homeService.updateOneAppointment(appointment);
		return "redirect:/trang-chu";
	}
	
	@RequestMapping(value = "/ghi-chu-lich-hen/{id}", method = RequestMethod.GET)
	public String reminderUpdateOne(@PathVariable int id, Model m) {
		Appointment appointment = homeService.findByIdAppointment(id);
		Reminder reminder = homeService.findReminderByAppointmentId(id);
		m.addAttribute("appointment", appointment);
		m.addAttribute("reminder", reminder);
		return "web/reminder";
	}
	
	@RequestMapping(value = "/ghi-chu-lich-hen/save", method = RequestMethod.POST)
	public String reminderUpdateSave(@ModelAttribute("reminder") Reminder reminder) {
		homeService.updateOneReminder(reminder);
		return "redirect:/trang-chu";
	}
	
	@RequestMapping(value = "/them-nguoi-tham-du/{id}", method = RequestMethod.GET)
	public String addUser(@PathVariable int id, Model m, @ModelAttribute("user") User user) {
		Appointment appointment = homeService.findByIdAppointment(id);
		m.addAttribute("appointment", appointment);
		return "web/addUser";
	}
	
	@RequestMapping(value = "/them-nguoi-tham-du/{id}/save", method = RequestMethod.POST)
	public String addUserSave(@ModelAttribute("user") User user, @PathVariable int id) {
		homeService.createOneUser(user, id);
		return "redirect:/trang-chu";
	}
	
	@RequestMapping(value = "/chi-tiet-lich-hen/{id}", method = RequestMethod.GET)
	public String appointmentDetail(@PathVariable int id, Model m, @ModelAttribute("user") User user, @ModelAttribute("reminder") Reminder reminder, @ModelAttribute("appointment") Appointment appointment) {
		m.addAttribute("appointment", homeService.findByIdAppointment(id));
		m.addAttribute("reminder", homeService.findReminderByAppointmentId(id));
		m.addAttribute("users", homeService.findAllUserByAppointmentId(id));
		return "web/detailAppointment";
	}
	
}
