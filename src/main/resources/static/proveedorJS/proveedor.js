$(document).ready(function () {
    $('#example').DataTable();
});


function eliminar(){

	var idProveedor = document.getElementById("txt_id").value;
	location.href="/admin/proveedor/eliminar/" + idProveedor;
	
}

function confirmar(idProveedor){
	document.getElementById("txt_id").value=idProveedor;

}