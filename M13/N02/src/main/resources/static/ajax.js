$(document).ready(function () {
	var url = window.location.href;
			
	$("#delete-btn").click(function () {
		$.ajax({
			url: url,
			method: "DELETE",
			success: function () {
				console.log("L'empleat s'ha esborrat correctament.");
			},
			error: function (error) {
				console.log(error);
			}
		});
	});
	
	$("#update-btn").click(function () {
		$.ajax({
			url: url,
			method: "PUT",
			success: function() {
				console.log("L'empleat s'ha actualitzat correctament.");
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
});