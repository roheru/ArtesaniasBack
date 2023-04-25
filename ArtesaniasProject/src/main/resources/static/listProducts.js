var btnMostrarMsjAjax=document.getElementById('btnlist');
function showListProducts(){
	var xhr=new XMLHttpRequest();
	xhr.open('GET','http://localhost:8080/products/listproduct',true);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				//alert('Hola primer ajax');
				//
				//$("#contenido").text(xhr.responseText);
                                console.log(xhr.responseText)
				var objetoJson = JSON.parse(xhr.responseText);
                                console.log(xhr.responseText);
				$("#contenido").text(objetoJson[0].codigoean);			
			}
		}
	}
	xhr.send();
}
btnMostrarMsjAjax.addEventListener('click',showListProducts);

$(document).ready(function() {
    $('ul li:has(ul)').hover(function(e) {
         $(this).find('ul').css({display: "block"});
     },
     function(e) {
         $(this).find('ul').css({display: "none"});
     });
});

