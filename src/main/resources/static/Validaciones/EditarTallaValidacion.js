function si(){
	
	caja1 = document.getElementById("txtnombre").value;

	//Validacion Nombres

	if (caja1.length >= 10) {
		Swal.fire({
  			icon: 'error',
  			title: 'Oops...',
 			text: 'Sólo se permiten menos de 10 letras para el nombre!',
  
})
		return false;
	}
	
	else if (/^\s+$/.test(caja1)) {
		document.getElementById("txtnombre").focus();
		document.getElementById("txtnombre").style.borderColor = "green";
		return true;
	}

	else if (/^([0-9])*$/.test(caja1)) {
		alert("El valor " + caja1 + " en el campo nombre no es valido");
		document.getElementById("txtnombre").focus();
		document.getElementById("txtnombre").style.borderColor = "red";
		return false;
	}

	else if (caja1.length <= 1) {
		Swal.fire({
  			icon: 'error',
  			title: 'Oops...',
 			text: 'Sólo se permiten mas de 1 letras para el nombre!',
		})
		return false;
	}
}