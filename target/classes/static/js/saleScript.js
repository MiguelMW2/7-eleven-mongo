
	function buscarProducto() {
		console.log("ready!");
		
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : window.location + "rest/product/search/",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				
				console.log("success");
				/*if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"---> Customer's Info: FirstName = " + 
												result.data.firstname + " ,LastName = " + result.data.lastname + "</p>");
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
				mongod --dbpath Documents/MongoDB/Databases
				username
				123
				*/
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
		
	}
