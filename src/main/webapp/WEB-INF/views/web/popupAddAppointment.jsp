<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>
<meta charset="UTF-8">
<title>Thông báo</title>
<style>
.popup {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 999;
}

.popup-content {
  background-color: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
  max-width: 400px;
  text-align: center;
}

.popup-content h2 {
  margin-top: 0;
}

.popup-content p {
  margin-bottom: 20px;
}

.button-container {
  display: flex;
  justify-content: center;
}

.confirm-btn, .cancel-btn {
  padding: 10px 20px;
  margin: 0 10px;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
}

.confirm-btn {
  background-color: #4CAF50;
  color: white;
  text-decoration: none;
}

.cancel-btn {
  background-color: #f44336;
  color: white;
  text-decoration: none;
}
</style>

</head>

<body>
<div class="popup">
  <div class="popup-content">
    <h2>Thông báo</h2>
    <p>Bạn đã có lịch hẹn vào thời điểm đó. Bạn có muốn thay thế cuộc hẹn này không?</p>
    <div class="button-container">
      <a href="/spring-mvc/tao-lich-hen" type="button" class="cancel-btn" data-dismiss="modal">Quay lại</a>
      <a href="#" type="button" class="confirm-btn" data-dismiss="modal">Xác nhận</a>
    </div>
  </div>
</div>
    
</body>

</html>