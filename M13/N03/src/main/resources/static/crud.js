$(document).ready(function () {
	var url = "http://localhost:8080/employees/";
	
	$(".delete-btn").click(function(event) {
		var button = $(this);
		var id = button.attr("data-id");
		
		$.ajax({
			url: url + id,
			method: "DELETE",
			success: function(success) {
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
	
	$("#update-form").submit(function(event) {
		event.preventDefault();
		
		var form = $(this);
		var id = form.find("input[name='update-id']").val();
		var name = form.find("input[name='update-name']").val();
		var job = form.find("select[name='update-job']").val();
		
		$.ajax({
			url: url + id,
			method: "PUT",
			data: JSON.stringify({
				//"id": id,
				"name": name,
				"job": job
			}),
			contentType: "application/json",
			succes: function(success) {
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
});