window.onload = function () {

    $('.formulario-registro').submit(function (e) {
        validar_clave(e);
    });

    function validar_clave(e) {

        var caract_invalido = " ";
        var caract_longitud = 4;
        var cla1 = $('.formulario-registro #pass1').val();
        var cla2 = $('.formulario-registro #pass2').val();
        var usuario = $(".formulario-registro #usuario").val();
        if (usuario == '') {
            $(".error").html('Debes introducir un nombre de usuario');
            e.preventDefault();
            return false;
        }
        if (cla1 == '' || cla2 == '') {
            $(".error").html('Debes introducir tu clave en los dos campos');
            //alert('Debes introducir tu clave en los dos campos.');
            //document.registro
            e.preventDefault();
            return false;
        }
        if (cla1.length < caract_longitud) {
            $(".error").html('Tu clave debe constar de ' + caract_longitud + ' carácteres o más');
            //alert('Tu clave debe constar de ' + caract_longitud + ' carácteres.');
            //document.registro
            e.preventDefault();
            return false;
        }
        if (cla1.indexOf(caract_invalido) > -1) {
            $(".error").html('La clave no puede contener un espacio');
            // alert("Las claves no pueden contener espacios");
            //document.registro
            e.preventDefault();
            return false;
        } else {
            if (cla1 != cla2) {
                $(".error").html('Las claves introducidas no son iguales');
                // alert("Las claves introducidas no son iguales");
                //document.registro
                e.preventDefault();
                return false;
            } else {
                //alert('Contraseña correcta');
                //$('.formulario-registro').trigger('submit');
                return true;
            }
        }
    }

}