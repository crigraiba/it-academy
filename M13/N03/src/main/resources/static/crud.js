$(document).ready(function () {
	var url = window.location.href;
	
	$("#delete-btn").click(function () {
		//endpoint += "/" + id;
		//console.log(endpoint);
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
			data: JSON.stringify({
					"name": name,
					"job": job
				}),
			success: function () {
				//window.location.href = "/employees";
			},
			error: function (error) {
				console.log(error);
			}
		});
	});
	
	/*$("#update-btn").click(function (name, job) {
		var data = JSON.stringify({
				"name": name,
				"job": job
			});
	
		$.ajax({
			url: url,
			method: "GET",
			data: data,
			success: function (data) {
				$.ajax({
					url: url,
					method: "PUT",
					data: data,
					success: function () {
					},
					error: function (error) {
					}
				});
			},
			error: function (error) {
				console.log(error);
			}
		});
	});*/
});