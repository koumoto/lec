function loginCheck(){
	if(form.user_id.value==="admin" && form.passwd.value==="admin"){
		location.href = "admin_index.html";
	}else{
		location.href = "error.html";
	}
}

function connecttext( textid, ischecked ) {
	if( ischecked == true ) {
		document.getElementById(textid).disabled = false;
	}else {
		document.getElementById(textid).disabled = true;
	  }
}

function disable(textid){
	document.getElementById(textid).disabled = false;
}
