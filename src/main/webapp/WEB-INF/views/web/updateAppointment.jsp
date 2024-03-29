<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>
<meta charset="UTF-8">
<title>Cập nhật lịch hẹn</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<style>

</style>

<body>

<div class="container mt-4">
  <form action ="save" method="POST">
   <tr>
	<td colspan="2">
		<h3>Chỉnh sửa thông tin lịch hẹn: ${appointment.name} </h3>
		<input type="hidden" name="id" value="${appointment.id}">
	</td>
   </tr>
    <div class="form-group">
      <label for="name">Tên cuộc hẹn</label>
      <input
        type="text"
        class="form-control"
        name="name"
        value="${appointment.name}"
     />
    </div>
	<div class="form-group">
      <label for="image">Ngày diễn ra</label>
      <input
        type="date"
        class="form-control"
        name="date"
        value="${appointment.date}"
      />
    </div>
    <div class="form-group">
      <label for="price">Địa điểm diễn ra</label>
      <input
        type="text"
        class="form-control"
        name="location"
        value="${appointment.location}"
      />
    </div>
    <div class="form-group">
      <label for="price">Giờ bắt đầu</label>
      <input
        type="text"
        class="form-control"
        name="start_time"
        value="${appointment.start_time}"
      />
    </div>
    <div class="form-group">
      <label for="price">Giờ kết thúc</label>
      <input
        type="text"
        class="form-control"
        name="end_time"
        value="${appointment.end_time}"
      />
    </div>
    <div class="form-group">
      <label for="price">Khoảng thời gian</label>
      <input
        type="text"
        class="form-control"
        name="duration"
        value="${appointment.duration}"
      />
    </div>
    <button type="submit" class="btn btn-primary">Lưu Lại</button>
  </form>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>    
</body>

</html>