// jQuery
// https://api.jquery.com/change/
// https://api.jquery.com/one/#one-events-data-handler

$('#fotoId').on('change', function(){
    // cria o objeto de FileReader
    var reader = new FileReader();
   
    // # manipulação do elemento svg
    
    // pega o elemento(svg) do html
    var svgTag = document.getElementsByTagName('svg')[0];
    if(svgTag != null) { // ou seja, diferente de null ou undefined
        // cria a tag img
        var imgTag = document.createElement('img');
        // adiciona a tag img o atributo id com valor avatarId
        imgTag.setAttribute('id', 'avatarId');
        // substitui(troca) a svg para a tag img
        svgTag.parentNode.replaceChild(imgTag, svgTag);
    }
    // /# manipulação do elemento svg

    reader.onloadend = function() {
        $('#avatarId').attr('src', reader.result);
    };
    reader.readAsDataURL(this.files[0]);
});