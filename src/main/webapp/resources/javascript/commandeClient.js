$(document).ready(function() {
	$("#codeArticle_search").on("keypress", function(e) {
		if(e.which == '13') {
			var codeSalle = $("#codeArticle_search").val();
			if(verifierClient() && codeSalle) {
				searchArticle(codeSalle);
			}
		}
	});
	
	$("#listClients").on("change", function(e) {
		if(verifierClient()) {
			$("#clientNotSelectedMsgBlock").hide("slow", function() {$("#clientNotSelectedMsgBlock").hide()});
			creerCommande($("#listClients option:selected").val());
		}
	});
	$("#btnEnrigtrerCommande").on("click", function() {
		$.getJSON("enrigstrerCommande", function(data) {
			if (data) {
				window.location=""+data;
			}
		});
	});
	
	$("#notFoundMsgBlock").hide();
	$("#clientNotSelectedMsgBlock").hide();
	$("#unexpectedErrorMsgBlock").hide();
	
});

function verifierClient() {
	var idClient = $("#listClients option:selected").val();
	if(idClient) {
		if (idClient === "-1") {
			$("#clientNotSelectedMsgBlock").show("slow", function() {$("#clientNotSelectedMsgBlock").show()});
			return false;
		}
		return true;
	}
}

function creerCommande(idClient) {
	if(idClient) {
		$.getJSON("creerCommande", {
			idClient: idClient,
			ajax: true
		},
		function(data) {
			console.log("client a ete mis a jour");
		});
	}
}

function updateDetailCommande(idReservation) {
	var json = $.parseJSON($("#json" + idReservation).text());
	var detailHtml = "";
	if(json) {
		for(var index = 0; index < json.length; index++) {
			detailHtml += 
						"<tr>"+
							"<td>" + json[index].salle.codeSalle + "</td>"+
							"<td>" + json[index].quantite + "</td>"+
							"<td>" + json[index].salle.prix + "</td>"+
							"<td>" + (json[index].salle.prix*json[index].quantite) + "</td>"+
						"</tr>";
		}
		$("#detailCommande").html(detailHtml);
	}	
}

function searchArticle(codeSalle) {
	if(codeSalle) {
		var detailHtml = "";
		$.getJSON("ajouterLigne", {
			codeSalle: codeSalle,
			ajax: true
		}, 
		function(data) {
			if(data) {
				var total = data.quantite * data.prix;
				if($("#qte" + data.salle.idSalle).length > 0 && $("#total" + data.salle.idSalle).length > 0) {
					$("#qte" + data.salle.idSalle).text(data.quantite);
					$("#total" + data.salle.idSalle).text(total);
				} else {
					detailHtml += 
						"<tr id='ligne" + data.salle.idSalle + "'>"+
							"<td>" + data.salle.idSalle + "</td>"+
							"<td id='qte" + data.salle.idSalle + "'>" + data.quantite + "</td>"+
							"<td>" + data.prix + "</td>"+
							"<td id='total" + data.salle.idSalle + "'>" + total + "</td>"+
							"<td ><button class='btn btn-link' onclick='supprimerLigneCommande(" + data.salle.idSalle + ")'><i class='fa fa-trash-o'></i></button></td>"+
						"</tr>";
					$("#detailNouvelleCommande").append(detailHtml);
				}
				$("#notFoundMsgBlock").hide("slow", function() {$("#notFoundMsgBlock").hide()});
				$("#codeArticle_search").val("");
			}
		}).fail(function() {
			$("#notFoundMsgBlock").show("slow", function() {$("#notFoundMsgBlock").show()});
		});
	}	
}


function supprimerLigneCommande(idSalle) {
	if($("#ligne" + idSalle).length > 0) {
		$.getJSON("supprimerLigne", {
			idSalle: idSalle,
			ajax: true
		},
		function(data){
			if(data) {
				$("#ligne" + idSalle).hide("slow", function() {$("#ligne" + idSalle).remove()});
			}
		});
	}
}