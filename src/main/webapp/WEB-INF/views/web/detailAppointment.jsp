<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>
<meta charset="UTF-8">
<title>Chi tiết lịch hẹn</title>
<style>
table {
        font-family: Arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
      }
      td, th {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
      }
      th {
        background-color: #f2f2f2;
      }
      .attendees {
        list-style: none;
        margin: 0;
        padding: 0;
      }
      .attendees li {
        margin-bottom: 4px;
      }
</style>
</head>

<body>
    <h1>Chi tiết lịch hẹn</h1>
    <table>
      <tr>
        <th>Tên cuộc hẹn:</th>
        <td>${appointment.name}</td>
      </tr>
      <tr>
        <th>Ngày diễn ra:</th>
        <td>${appointment.date}</td>
      </tr>
      <tr>
        <th>Địa điểm:</th>
        <td>${appointment.location}</td>
      </tr>
      <tr>
        <th>Giờ bắt đầu:</th>
        <td>${appointment.start_time}</td>
      </tr>
      <tr>
        <th>Giờ kết thúc:</th>
        <td>${appointment.end_time}</td>
      </tr>
      <tr>
        <th>Khoảng thời gian:</th>
        <td>${appointment.duration}</td>
      </tr>
      <tr>
        <th>Người tham dự:</th>
        <td>
          <ul class="attendees">
          <c:forEach var = "item" items = "${users}">
            <li>${item.name}</li>
          </c:forEach>
          </ul>
        </td>
      </tr>
      <tr>
        <th>Ghi chú:</th>
        <td>${reminder.detail}</td>
      </tr>
    </table>
</body>

</html>