$(document).ready(function () {
    $('#exampleS').DataTable();
});


function eliminar(){2

	var idTalla = document.getElementById("txt_id").value;
	location.href="/admin/talla/eliminar/" + idTalla;
	
}

function confirmar(idTalla){
	document.getElementById("txt_id").value=idTalla;

}