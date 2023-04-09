<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>
<meta charset="UTF-8">
<title>Tạo lịch hẹn</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script>
$(document).ready(function() {
	  $('form').submit(function(event) {
	    // ngăn chặn trình duyệt thực hiện hành động mặc định khi form được submit
	    event.preventDefault();
	    
	    // lấy dữ liệu từ form
	    var formData = {
	      name: $('input[name=name]').val(),
	      date: $('input[name=date]').val(),
	      location: $('input[name=location]').val(),
	      start_time: $('input[name=start_time]').val(),
	      end_time: $('input[name=end_time]').val(),
	      duration: $('input[name=duration]').val()
	    };
	    
	    // gửi yêu cầu kiểm tra cuộc hẹn đã tồn tại hay chưa đến máy chủ
	    $.ajax({
	      type: 'POST',
	      url: 'check-appointment',
	      data: formData,
	      dataType: 'json',
	      encode: true
	    })
	      .done(function(data) {
	        // nếu cuộc hẹn đã tồn tại, hiển thị thông báo lỗi
	        if (!data.isValid) {
	          $('#error-message').text(data.errorMessage);
	        } else {
	          // nếu cuộc hẹn chưa tồn tại, submit form
	          $('form').unbind('submit').submit();
	        }
	      });
	  });
	});
</script>

</head>

<body>
		<div class="modal-dialog">
			<div class="modal-content">
				<form method = "get" action = "add">
					<div class="modal-header">						
						<h4 class="modal-title">Thêm lịch hẹn</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
 					<div class="modal-body">
 						<div class="form-group">
							<label>Tên lịch hẹn</label>
							<input name="name" type="text" class="form-control" required = "required"/>
							<div id="error-message"></div>
						</div>					
						<div class="form-group">
							<label>Ngày diễn ra</label>
							<input name="date" type="date" class="form-control" required = "required"/>
						</div>
						<div class="form-group">
							<label>Địa điểm</label>
							<input name="location" type="text" class="form-control" required = "required"/>
						</div>
						<div class="form-group">
							<label>Giờ bắt đầu</label>
							<input name="start_time" type="text" class="form-control" required = "required"/>
						</div>	
						<div class="form-group">
							<label>Giờ kết thúc</label>
							<input name="end_time" type="text" class="form-control" required = "required"/>
						</div>
						<div class="form-group">
							<label>Khoảng thời gian</label>
							<input name="duration" type="text" class="form-control" required = "required"/>
						</div>		
					</div>  
					<div class="modal-footer">
						<a href="/spring-mvc/trang-chu" type="button" class="btn btn-default" data-dismiss="modal">Cancel</a>
						<input type="submit" class="btn btn-success" value="Add">
					</div> 
				</form>
			</div>
		</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>    
</body>

</html>