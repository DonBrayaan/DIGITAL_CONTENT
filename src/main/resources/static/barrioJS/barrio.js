$(document).ready(function () {
    $('#exampleS').DataTable();
});


function eliminar(){2

	var idBarrio = document.getElementById("txt_id").value;
	location.href="/admin/barrio/eliminar/" + idBarrio;
	
}

function confirmar(idBarrio){
	document.getElementById("txt_id").value=idBarrio;

}