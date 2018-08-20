$(function() {

	var detailSale = [];

	$("#searchProduct").click(function () {
		let name = $("#name").val();
		let upc = $("#upc").val();
		let idSale = $("#idSale").val();
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/rest/product/search/" + name + "/" + upc,
			dataType : 'json',
			success : function(result) {
				$("#products").empty();
				$.each(result, function (index, product) {
					let table = "<tr>";
					table += "<td>" + product.name + "</td>";
					table += "<td>" + product.description + "</td>";
					table += "<td>" + product.price + "</td>";
					table += "<td>" + product.stock + "</td>";
					table += "<td>" + product.upc + "</td>";
					table += "<td><button onclick='selectProduct(" + JSON.stringify(product) + ")'>" + "Seleccionar" + "</button></td>";
					table += "</tr>";
					$("#products").append(table);
					$("#products td button").addClass("btn btn-danger w-100");
				});
			},
			error : function(e) {
				alert("No se encontraron productos");
			}
		});
	});

	selectProduct = function (product) {
		let selectedProduct = "tbody#selectedProducts tr#" + product.id;
		if(! $(selectedProduct).length > 0) {
			detailSale.push(
				{
					"product" : product,
					"quantity" : 1
				}
			);
			let table = "<tr id='" + product.id + "'>";
			table += "<td>" + product.name + "</td>";
			table += "<td>" + product.description + "</td>";
			table += "<td>" + product.price + "</td>"
			table += "<td class='quantity'>" + 1 + "</td>"
			table += "</tr>";
			$("#selectedProducts").append(table);
		}
		else {
			let detail = findObject( detailSale, "id", product.id );
			detail.quantity = detail.quantity + 1;
			$("#selectedProducts tr#" + product.id + " td.quantity").text(detail.quantity);
			console.log(detailSale);
		}
	}

	$("#sendDetailSale").click(function () {
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/rest/detailSale/save",
			data : JSON.stringify(detailSale),
			dataType : 'text',
			success : function(result) {
				window.location.href = "/sale/payment/" + result;
			},
			error : function(e) {
				alert("Error!");
			}
		});
	});

	findObject = function (array, key, value) {
	    for (var i = 0; i < array.length; i++) {
	        if (array[i]["product"][key] === value) {
	            return array[i];
	        }
	    }
	    return null;
	}
});
