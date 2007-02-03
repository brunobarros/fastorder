try{
    xmlhttp = new XMLHttpRequest();
}catch(ee){
    try{
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    }catch(e){
        try{
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }catch(E){
            xmlhttp = false;
        }
    }
}

function load(link, div){
    var conteudo = document.getElementById(div);
    conteudo.innerHTML = '<div id="loading"><img src="images/ajax-loader.gif" /></div>';
    xmlhttp.open("GET", link ,true);

    xmlhttp.onreadystatechange=function() {

        if (xmlhttp.readyState==4){

            var texto=xmlhttp.responseText

            texto=texto.replace(/\+/g," ")
            texto=unescape(texto)
			
            var conteudo=document.getElementById(div)
            conteudo.innerHTML=texto
        }
    }

    xmlhttp.send(null)
}