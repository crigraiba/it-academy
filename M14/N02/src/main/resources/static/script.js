$(document).ready(function () {
	var url = "http://localhost:8080/shops";
	
	$(".delete-btn").click(function (event) {
		event.preventDefault();
		
		var button = $(this);
		var id = button.attr("data-id");
		
		$.ajax({
			method: "DELETE",
			url: url + "/" + id + "/pictures",
			success: function (success) {
				window.location.href = url + "/" + id + "/pictures";
			},
			error: function (error) {
				console.log(error);
			}
		});
	});
});