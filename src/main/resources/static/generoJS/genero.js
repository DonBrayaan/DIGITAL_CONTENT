$(document).ready(function () {
    $('#exampleS').DataTable();
});


function eliminar(){2

	var idGenero = document.getElementById("txt_id").value;
	location.href="/admin/genero/eliminar/" + idGenero;
	
}

function confirmar(idGenero){
	document.getElementById("txt_id").value=idGenero;

}