$(document).ready(function() {
	$("#tauxTva").on("keyup", function() {
		tvaKeyUpFunction();
	});
});

tvaKeyUpFunction = function() {
	var prix = $("#prix").val();
	/*var tauxTva = $("#tauxTva").val();
	var prixUnitTTC = parseFloat(parseFloat(prixUnitHT) * parseFloat(tauxTva) / 100 + parseFloat(prixUnitHT));*/
	$("#prix").val(prix);
}