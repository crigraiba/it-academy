$(document).ready(function () {
	var url = window.location.href;
	
	$("#delete-btn").click(function () {
		$.ajax({
			url: url,
			method: "DELETE",
			success: function () {
				window.location.href = "/employees";
			},
			error: function (error) {
				console.log(error);
			}
		});
	});
	
	$("#update-btn").click(function (name, job) {
		$.ajax({
			url: url,
			method: "PUT",
			data: JSON.parse("{'name': name, 'job': job}"),
			success: function() {
				window.location.href = "/employees";
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
});