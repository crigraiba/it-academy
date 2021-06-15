$(document).ready(function () {
	var url = "http://localhost:8080/employees";
	
	$(".delete-btn").click(function (event) {
		event.preventDefault();
		
		var button = $(this);
		var id = button.attr("data-id");
		
		$.ajax({
			method: "DELETE",
			url: url + "/" + id,
			success: function (success) {
				window.location.href = url;
			},
			error: function (error) {
				console.log(error);
			}
		});
	});
	
	$("#update").submit(function (event) {
		event.preventDefault();
		
		var form = $(this);
		var id = form.attr("data-id");
		var name = form.find("input[name='name']").val();
		var job = form.find("select[name='job']").val();
		
		$.ajax({
			method: "PUT",
			url: url + "/" + id,
			data: JSON.stringify({
				"name": name,
				"job": job
			}),
			contentType: "application/json",
			success: function (success) {
				window.location.href = url + "/" + id;
			},
			error: function (error) {
				console.log(error);
			}
		});
	});
});